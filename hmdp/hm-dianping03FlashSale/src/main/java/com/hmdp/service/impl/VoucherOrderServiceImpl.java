package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.utils.RedisWorker;
import com.hmdp.utils.UserHolder;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {
    @Resource
    private ISeckillVoucherService seckillVoucherService;
    @Resource
    private RedisWorker redisWorker;

    /**
     * 执行秒杀优惠券下单操作
     * 流程：验证秒杀券信息 -> 检查活动时间 -> 扣减库存 -> 创建订单
     * 使用 synchronized 锁住用户 ID，防止同一用户并发下单
     * 
     * @param voucherId 秒杀券 ID，用于标识要购买的秒杀优惠券
     * @return Result 包含订单 ID 的返回结果，如果失败则包含错误信息
     */
    @Override
    public Result seckillVoucher(Long voucherId) {
        // 查询秒杀券信息
        SeckillVoucher voucher = seckillVoucherService.getById(voucherId);

        // 验证秒杀活动时间是否有效
        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
            return Result.fail("秒杀活动尚未开始！");
        }
        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
            return Result.fail("秒杀活动已经结束！");
        }
        // 检查库存是否充足
        if (voucher.getStock() < 1) {
            return Result.fail("库存不足！");
        }
        
        // 获取当前用户 ID
        Long userId = UserHolder.getUser().getId();
        // 使用 synchronized 锁住用户 ID，确保同一用户的请求串行执行，不同用户获取的锁不一样，防止一人多单
        synchronized (userId.toString().intern()) {//事务提交后再释放锁
            // 通过 Spring AOP 代理调用 createVoucherOrder 方法，确保事务生效
            /* 不能直接调用 createVoucherOrder，
             * 否则属于同类内部调用（self-invocation），会绕过 Spring 生成的代理对象，
             * @Transactional 事务增强不会生效。
             * 这里通过 AopContext.currentProxy() 拿到代理对象，再调用方法，事务才能生效。
             */
            IVoucherOrderService proxy = (IVoucherOrderService) AopContext.currentProxy();
            return proxy.createVoucherOrder(voucherId);
        }
    }

    @Transactional
    public Result createVoucherOrder(Long voucherId) {
        //检查当前用户是否下过单（一人一单）
        Long userId = UserHolder.getUser().getId();
        Integer count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
        if (count > 0) {
            //当前用户已经下单过了
            return Result.fail("不能重复下单！");
        }

        // 扣减库存，使用乐观锁方式更新，这里是在与数据库Mysql进行交互
        boolean success = seckillVoucherService
                .update().setSql("stock = stock - 1")
                .eq("voucher_id", voucherId)
                .gt("stock", 0)
                .update();
        if (!success) {
            return Result.fail("库存不足！");
        }

        // 创建订单对象并设置基本信息
        VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setVoucherId(voucherId);

        // 使用 Redis Worker 生成全局唯一订单 ID
        Long orderId = redisWorker.nextId("order");
        voucherOrder.setId(orderId);

        // 获取当前用户 ID 并设置到订单中
        voucherOrder.setUserId(userId);

        save(voucherOrder);
        return Result.ok(orderId);
    }
}
