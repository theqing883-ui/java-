package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class SpringDataStringRedisApplicationTests {
    private static final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void redisTemplateTest() {
        redisTemplate.opsForValue().set("老大2", "虎哥2");
        System.out.println(redisTemplate.opsForValue().get("老大2"));
    }

    @Test
    void redisStringTemplateTest() throws JsonProcessingException {
        User user = new User("胡歌ge", 20);
        String userJson = mapper.writeValueAsString(user);
        redisTemplate.opsForValue().set("user:1", userJson);
        String s = redisTemplate.opsForValue().get("user:1");
        User user1 = mapper.readValue(s, User.class);
        System.out.println(user1);
    }
}
