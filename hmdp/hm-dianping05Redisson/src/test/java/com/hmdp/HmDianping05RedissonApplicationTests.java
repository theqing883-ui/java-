package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class HmDianping05RedissonApplicationTests {
    @Autowired
    private ShopServiceImpl shopService;

    @Test
    public void saveShopToRedisTest() throws InterruptedException {
        shopService.saveShopToRedis(1L, 20L);
    }

  /*  @Resource(name = "redissonClient1")
    private RedissonClient redissonClient1;
    @Resource(name = "redissonClient2")
    private RedissonClient redissonClient2;
    @Resource(name = "redissonClient3")
    private RedissonClient redissonClient3;

    private RLock multiLock;

    @BeforeEach
    void setUp() {
        // 1. 分别获取三台机器上的锁对象
        RLock lock1 = redissonClient1.getLock("order:lock");
        RLock lock2 = redissonClient2.getLock("order:lock");
        RLock lock3 = redissonClient3.getLock("order:lock");

        // 2. 组合成联锁 MultiLock
        multiLock = redissonClient1.getMultiLock(lock1, lock2, lock3);
    }

    @Test
    void testMultiLockReentrant() {
        log.info("开始尝试获取锁...");
        methodA(3); // 尝试递归调用 3 次
        log.info("所有任务完成，锁已彻底释放");
    }

    private void methodA(int count) {
        if (count <= 0)
            return;

        // 尝试加锁，最多等待 10s，加锁后 30s 自动解锁
        boolean isLock = multiLock.tryLock();
        if (!isLock) {
            log.error("获取锁失败！次数：{}", count);
            return;
        }

        try {
            log.info("成功获取锁！当前递归深度：{}，线程ID：{}", count, Thread.currentThread().getId());

            // 模拟业务处理
            Thread.sleep(100);

            // 递归再次进入，测试可重入性
            methodA(count - 1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.warn("正在释放锁，深度：{}", count);
            multiLock.unlock();
        }
    }*/
}

