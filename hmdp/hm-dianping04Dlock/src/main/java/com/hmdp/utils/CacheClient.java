package com.hmdp.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class CacheClient {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object value, Long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().
                set(key, JSONUtil.toJsonStr(value), time, timeUnit);
    }

    public <R, ID> R queryWithPassThrough(String key, ID id, Class<R> type, Function<ID, R> dbFallBack,
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
    }
}
