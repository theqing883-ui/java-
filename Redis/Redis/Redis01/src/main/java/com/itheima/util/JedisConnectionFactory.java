package com.itheima.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis 连接池工厂类
 * 用于管理和提供 Redis 连接
 */
public class JedisConnectionFactory {

    // 全局唯一的连接池实例（单例模式）
    private static final JedisPool jedisPool;

    // 静态代码块，在类加载时初始化连接池
    static {
        // 创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(8);

        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(8);

        // 设置最小空闲连接数
        jedisPoolConfig.setMinIdle(0);

        // 设置获取连接时的最大等待时间（毫秒）
        jedisPoolConfig.setMaxWaitMillis(200);

        // 创建 Jedis 连接池
        jedisPool = new JedisPool(
                jedisPoolConfig,           // 连接池配置
                "192.168.106.129",        // Redis 服务器 IP
                6379,                      // Redis 端口
                1000,                      // 连接超时时间（毫秒）
                "123456"                   // Redis 密码
        );
    }


    /**
     * 从连接池获取 Jedis 连接
     * @return Jedis 连接实例
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭连接池（应用关闭时调用）
     */
    public static void closePool() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }
}