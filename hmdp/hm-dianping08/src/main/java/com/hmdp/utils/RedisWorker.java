package com.hmdp.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class RedisWorker {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    private static final long BEGIN_TIMESTAMP = 1767225600;
    /**
     * 使用 Redis 生成全局唯一 ID
     * ID 结构：时间戳（32 位）+ 序列号（32 位）
     * 
     * @param keyPrefix 业务前缀，用于区分不同类型的 ID（如 "order"、"user" 等）
     * @return 生成的全局唯一 ID，由时间戳和自增序列号组成
     */
    public long nextId(String keyPrefix){
        // 获取当前 UTC 时间
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        
        // 计算相对于起始时间戳的偏移量
        long timeStamp = nowSecond - BEGIN_TIMESTAMP;
        
        // 生成格式化的日期字符串，用于按天统计
        String date = now.format(DateTimeFormatter.ofPattern("yyy:MM:dd"));
        
        // 在 Redis 中自增计数，key 格式：icr:{keyPrefix}:{date}
        long count = stringRedisTemplate.opsForValue().
                increment("icr:" + keyPrefix + ":" + date);
        
        // 通过位运算组合时间戳和计数器生成最终 ID
        return timeStamp << 32 | count;
    }

    /*public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2026,1,1,0,0,0);
        long second = time.toEpochSecond(ZoneOffset.UTC);
        *//*UTC:国际标准时间系统*//*
        System.out.println(second);
    }*/
}
