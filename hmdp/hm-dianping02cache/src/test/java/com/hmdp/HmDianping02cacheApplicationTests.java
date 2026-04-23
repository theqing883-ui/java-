package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HmDianping02cacheApplicationTests {
    @Autowired
    private ShopServiceImpl shopService;

    @Test
   public void saveShopToRedisTest() throws InterruptedException {
        shopService.saveShopToRedis(4L,20L);
    }

}
