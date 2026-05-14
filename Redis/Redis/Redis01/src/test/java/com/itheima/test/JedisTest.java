package com.itheima.test;

import com.itheima.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedis = new Jedis("192.168.106.129", 6379);
        jedis.auth("123456");
        jedis.select(0);
//        jedis = JedisConnectionFactory.getJedis();

    }

    @Test
    void test() {
        String res = jedis.set("name", "jerry");
        System.out.println(res);
        System.out.println(jedis.get("name"));
        jedis.hset("user:1", "name", "jerry");
        jedis.hset("user:1", "age", "27");
        System.out.println(jedis.hmget("user:1", "name", "age"));
    }

    @AfterEach
    void tearDown() {
//        JedisConnectionFactory.closePool();
        if (jedis != null) {
            jedis.close();
        }
    }
}
