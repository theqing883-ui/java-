package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.RedisWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class HmDianping03FlashSaleApplicationTests {
    @Autowired
    private ShopServiceImpl shopService;
    @Autowired
    private RedisWorker redisWorker;
    /*创建线程池*/
    private ExecutorService es = Executors.newFixedThreadPool(300);

    @Test
    public void saveShopToRedisTest() throws InterruptedException {
        shopService.saveShopToRedis(1L, 20L);
    }

    @Test
    public void nextIdTest() throws InterruptedException {
        // 1. 创建计数器，初始值为任务数量
        CountDownLatch latch = new CountDownLatch(300);
        Runnable task = () ->{
            try {
                for (int i = 0; i < 100; i++) {
                    long id = redisWorker.nextId("order");
                    System.out.println("id :" + id);
                }
            } finally {
                // 2. 每个任务跑完，计数器减 1
                latch.countDown();
            }
        };

        for (int i = 0; i < 300; i++) {
            es.submit(task);
        }
        // 3. 主线程在这里阻塞，直到计数器变 0
        latch.await();
    }


}
