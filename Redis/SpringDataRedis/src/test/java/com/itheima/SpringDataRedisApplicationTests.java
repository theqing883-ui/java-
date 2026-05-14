package com.itheima;

import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
//    private RedisTemplate<String, Object> redisTemplate;


    @Test
    void redisTemplateTest() {
        redisTemplate.opsForValue().set("老大", "虎哥");
        System.out.println(redisTemplate.opsForValue().get("老大"));
    }

    @Test
    void redisUserTemplateTest() {
        User user = new User("胡歌", 20);
        redisTemplate.opsForValue().set("user:1", user);
        System.out.println(redisTemplate.opsForValue().get("user:1"));
    }

}
