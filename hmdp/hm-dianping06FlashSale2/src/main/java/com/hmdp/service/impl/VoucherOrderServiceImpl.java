package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.utils.RedisWorker;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 秒杀下单业务实现
 * 核心设计：Redis 预检 + 阻塞队列 + 异步落库
 */
@Slf4j
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {

    // 1. 加载 Lua 脚本，保证库存校验与一人一单校验的原子性
    private static final DefaultRedisScript<Long> SECKILL_SCRIPT;
    // 2. 异步处理订单的线程池：负责在后台慢慢把队列里的任务存入数据库
    private static final ExecutorService SECKILL_ORDER_EXECUTOR =
            new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000));

    static {
        SECKILL_SCRIPT = new DefaultRedisScript<>();
        SECKILL_SCRIPT.setLocation(new ClassPathResource("seckill.lua"));
        SECKILL_SCRIPT.setResultType(Long.class);
    }

    @Resource
    StringRedisTemplate stringRedisTemplate;
    /**
     * 内部类：后台“勤务兵”
     * 不断从队列中“捡”任务去执行
     */
    String queueName = "stream.orders";
    @Resource
    private ISeckillVoucherService seckillVoucherService;
    @Resource
    private RedisWorker redisWorker;
    @Resource(name = "redissonClient1")
    private RedissonClient redissonClient;
    /**
     * 关键变量：用于在异步线程中调用事务方法
     * 因为异步线程无法通过 AopContext 获取代理，所以需要提前保存
     */
    @Resource
    private IVoucherOrderService proxy;

    /**
     * 项目启动后立即执行，开启后台监听线程
     */
    @PostConstruct
    private void init() {
        SECKILL_ORDER_EXECUTOR.submit(new voucherOrderHandler());
    }


    /**
     * 第一阶段：Redis 预检
     * 此时请求还在主线程（Tomcat 线程池），响应速度极快
     */
    @Override
    public Result seckillVoucher(Long voucherId) {
        //获取用户Id
        Long userId = UserHolder.getUser().getId();
        //获取订单Id
        long orderId = redisWorker.nextId("order");

        // 1. 执行 Lua 脚本：判断库存、一人一单。0-成功，1-库存不足，2-重复下单
        Long re = stringRedisTemplate.execute(
                SECKILL_SCRIPT, Collections.emptyList(),
                voucherId.toString(), userId.toString(),
                String.valueOf(orderId)
        );
        int result = re.intValue();
        if (result != 0) {
            return Result.fail(result == 1 ? "库存不足！" : "不允许重复下单！");
        }
        // 4. 【核心细节】获取当前类的代理对象。
        // 因为异步线程是新开的，它不在 Spring 的上下文中，无法通过 AopContext.currentProxy() 动态获取。
        // 我们在主线程先拿好存起来。

//        proxy = (IVoucherOrderService) AopContext.currentProxy();
        // 5. 返回订单 ID，用户前端可以开始轮询订单状态了
        return Result.ok(orderId);
    }

    /**
     * 辅助方法：处理具体的订单任务（加锁 + 调用事务）
     */
    public void handlerVoucherOrder(VoucherOrder voucherOrder) {
        Long userId = voucherOrder.getUserId();
        // 即使 Redis 校验过，异步落库时仍建议加分布式锁，保证数据绝对安全
        // 这里的校验针对的是并发线程，不对Mysql进行查询
        RLock lock = redissonClient.getLock("lock:order:" + userId);
        boolean isLock = lock.tryLock();
        if (!isLock) {
            log.error("用户 {} 重复下单，任务丢弃", userId);
            return;
        }
        try {
            // 使用提前保存好的 proxy 调用，确保 @Transactional 生效
            proxy.createVoucherOrder(voucherOrder);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 第二阶段：数据库落库（真实下单）
     * 此时在异步线程池中运行
     */
    @Transactional
    public void createVoucherOrder(VoucherOrder voucherOrder) {
        // 1. 一人一单数据库二次校验（兜底）
        Long userId = voucherOrder.getUserId();
        Long voucherId = voucherOrder.getVoucherId();
        Integer count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
        if (count > 0) {
            return; // 已处理过的订单
        }
        // 2. 扣减库存（乐观锁）
        boolean success = seckillVoucherService
                .update().setSql("stock = stock - 1")
                .eq("voucher_id", voucherId)
                .gt("stock", 0) // CAS：库存必须大于0
                .update();
        if (!success) {
            log.error("数据库扣减库存失败");
            return;
        }
        // 3. 保存订单到数据库
        save(voucherOrder);
    }

    private class voucherOrderHandler implements Runnable {
        /**
         * 订单处理器线程任务
         */
        @Override
        public void run() {
            while (true) {
                try {
                    // 1. 获取消息队列中的订单信息
                    // Consumer.from("g1", "c1"): 指定消费者组 g1 和消费者 c1
                    // count(1): 每次只读 1 条消息
                    // block(Duration.ofSeconds(2)): 如果没有消息，阻塞等待 2 秒
                    // ReadOffset.lastConsumed(): 对应 ">" 标识，读取从未消费过的“新消息”
                    List<MapRecord<String, Object, Object>> list = stringRedisTemplate.opsForStream().read(
                            Consumer.from("g1", "c1"),
                            StreamReadOptions.empty().count(1).block(Duration.ofSeconds(2)),
                            StreamOffset.create(queueName, ReadOffset.lastConsumed())
                    );

                    // 2. 判断消息是否为空
                    if (list == null || list.isEmpty()) {
                        continue; // 如果没有新消息，继续下一次循环
                    }

                    // 3. 解析消息并执行下单逻辑
                    MapRecord<String, Object, Object> record = list.get(0);
                    Map<Object, Object> values = record.getValue();
                    // 将 Redis 返回的 Map 转换为 VoucherOrder 实体对象
                    VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(values, new VoucherOrder(), true);

                    // 4. 执行落库操作（包含数据库插入和库存扣减）
                    handlerVoucherOrder(voucherOrder);

                    // 5. 【关键】ACK 确认消息：告诉 Redis 该消息已成功处理，从 Pending-list 中移除
                    stringRedisTemplate.opsForStream().acknowledge(queueName, "g1", record.getId());

                } catch (Exception e) {
                    // 6. 如果在处理过程中发生异常，消息会进入 Pending-list (待处理列表)
                    log.error("处理订单异常！消息将进入 Pending-list", e);
                    // 启动“救火逻辑”，尝试去 Pending-list 重新处理那些漏掉的消息
                    handlerPending();
                }
            }
        }

        /**
         * 异常补救逻辑：专门处理那些“已取走但未 ACK”的积压消息
         */
        private void handlerPending() {
            while (true) {
                try {
                    // 1. 读取 Pending-list 中的消息
                    // ReadOffset.from("0"): 对应 "0" 标识，从第一个待处理消息开始读
                    List<MapRecord<String, Object, Object>> list = stringRedisTemplate.opsForStream().read(
                            Consumer.from("g1", "c1"),
                            StreamReadOptions.empty().count(1), // Pending 消息一般直接读，不需要 block 阻塞
                            StreamOffset.create(queueName, ReadOffset.from("0"))
                    );

                    // 2. 判断 Pending 消息是否为空
                    if (list == null || list.isEmpty()) {
                        // 如果 Pending-list 已经清空，说明历史遗留问题已解决，跳出循环回到主逻辑
                        break;
                    }

                    // 3. 解析并重新执行处理逻辑
                    MapRecord<String, Object, Object> record = list.get(0);
                    Map<Object, Object> values = record.getValue();
                    VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(values, new VoucherOrder(), true);

                    // 4. 再次尝试下单
                    handlerVoucherOrder(voucherOrder);

                    // 5. 【关键】处理成功后 ACK，将其从 Pending-list 中彻底踢出
                    stringRedisTemplate.opsForStream().acknowledge(queueName, "g1", record.getId());

                } catch (Exception e) {
                    // 6. 如果 Pending 逻辑还报错（比如数据库依然挂着），为了防止 CPU 飙升，强制休眠片刻
                    log.error("Pending-list 处理再次异常！", e);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                    }
                    // 这里不需要 break，会继续在 while 循环里死磕 Pending 消息，直到成功
                }
            }
        }
    }
}
