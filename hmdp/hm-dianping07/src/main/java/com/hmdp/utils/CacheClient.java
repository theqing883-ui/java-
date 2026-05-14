package com.hmdp.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Slf4j
@Component
public class CacheClient {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object value, Long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().
                set(key, JSONUtil.toJsonStr(value), time, timeUnit);
    }

    /*public <R, ID> R queryWithPassThrough(String key, ID id, Class<R> type, Function<ID, R> dbFallBack,
                                          Long time, TimeUnit timeUnit) {
        long TTL = RedisConstants.CACHE_SHOP_TTL;
        //先查询Redis中商铺信息
        String Json = stringRedisTemplate.opsForValue().get(key + id);
        if (StrUtil.isNotBlank(Json)) {
            //查询到信息直接返回
            return JSONUtil.toBean(Json, type);
        }
        //是否命中空值
        if (Json != null) {
            return null;
        }
        //Redis未查询到，再查数据库
        R r = dbFallBack.apply(id);
        if (r == null) {
            //数据库中也没有,RandomUtil.randomInt(6)解决缓存雪崩
            set(key + id, "", time + RandomUtil.randomInt(6), timeUnit);
            return null;
        }
        //数据库中查到了,先保存到Redis，再返回
        set(key + id, r, time + RandomUtil.randomInt(6), timeUnit);
        return r;
    }*/


    public <R, ID> R queryWithPassThrough2(String json, String key, ID id, Class<R> type,
                                           Function<ID, R> dbFallBack, Long time, TimeUnit timeUnit) {
        // 1. 穿透判定：如果是空字符串 "" (注意 json != null && json.isEmpty())
        if (json != null) {
            return null; // 说明是之前缓存的空值，直接返回
        }

        // 2. Redis 彻底没数据 (json == null)，查数据库
        R r = dbFallBack.apply(id);
        if (r == null) {
            // 数据库也没有，存入空字符串防止穿透
            stringRedisTemplate.opsForValue().set(key + id, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
            return null;
        }

        // 3. 数据库有数据，包装成 RedisData 存入（为了配合逻辑过期方案）
        RedisData redisData = new RedisData();
        redisData.setData(r);
        // 设置逻辑过期时间
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(timeUnit.toSeconds(time)));

        // 写入 Redis，注意：逻辑过期方案通常不设 Redis 的 TTL，或者设得非常长
        stringRedisTemplate.opsForValue().set(key + id, JSONUtil.toJsonStr(redisData));
//        log.error("重建完成！");
        return r;
    }
}
