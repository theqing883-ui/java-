package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    // ... existing code ...

    /**
     * 创建并配置 Redisson 客户端实例
     *
     * @return RedissonClient Redisson 客户端实例，用于执行 Redis 操作
     */
    @Bean
    public RedissonClient redissonClient1() {
        /* 创建 Redisson 配置对象 */
        Config config = new Config();

        /* 配置 Redis 单机服务器地址和密码 */
        config.useSingleServer().setAddress("redis://192.168.106.129:6379")
                .setPassword("123456");

        /* 根据配置创建并返回 Redisson 客户端实例 */
        return Redisson.create(config);
    }

  /*  @Bean
    public RedissonClient redissonClient2() {
        *//* 创建 Redisson 配置对象 *//*
        Config config = new Config();

        *//* 配置 Redis 单机服务器地址和密码 *//*
        config.useSingleServer().setAddress("redis://192.168.106.129:7001")
                .setPassword("123456");

        *//* 根据配置创建并返回 Redisson 客户端实例 *//*
        return Redisson.create(config);
    }

    @Bean
    public RedissonClient redissonClient3() {
        *//* 创建 Redisson 配置对象 *//*
        Config config = new Config();

        *//* 配置 Redis 单机服务器地址和密码 *//*
        config.useSingleServer().setAddress("redis://192.168.106.129:7002")
                .setPassword("123456");

        *//* 根据配置创建并返回 Redisson 客户端实例 *//*
        return Redisson.create(config);
    }
*/
}
