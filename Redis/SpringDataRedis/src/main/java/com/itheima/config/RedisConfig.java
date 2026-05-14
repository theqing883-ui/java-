package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * 创建并配置 RedisTemplate Bean，用于操作 Redis 数据库
     * 
     * @param redisConnectionFactory Redis 连接工厂，由 Spring 容器自动注入，用于建立与 Redis 服务器的连接
     * @return 配置完成的 RedisTemplate 实例，泛型类型为<String, Object>，支持字符串键和任意类型值的存储
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 创建 RedisTemplate 实例
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        
        // 创建 JSON 序列化器，用于将对象序列化为 JSON 格式存储
        GenericJackson2JsonRedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer();
        
        // 设置 key 和 hashKey 使用字符串序列化器
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        
        // 设置普通 value 使用 JSON 序列化器，支持复杂对象的存储
        template.setValueSerializer(redisSerializer);
        
        // 设置 hashValue 使用 JSON 序列化器，支持复杂对象的存储
        template.setHashValueSerializer(redisSerializer);
        return template;
    }
}
