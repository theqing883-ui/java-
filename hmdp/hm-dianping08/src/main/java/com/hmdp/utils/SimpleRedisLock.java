package com.hmdp.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SimpleRedisLock implements ILock {

    private static final String KEY_PREFIX = "lock:";
    private static final String UUID_PREFIX = UUID.randomUUID().toString().replace("-", "") + "-";
    private static final DefaultRedisScript<Long> UNLOCK_SCRIPT;
    /*DefaultRedisScript<Long> 中的 Long 表示 Lua 脚本执行后的返回值类型。*/
    static {
        UNLOCK_SCRIPT = new DefaultRedisScript<>();
        /*加载lua脚本*/
        UNLOCK_SCRIPT.setLocation(new ClassPathResource("unlock.lua"));
    }

    private StringRedisTemplate stringRedisTemplate;
    private String lockName;

    public SimpleRedisLock(StringRedisTemplate stringRedisTemplate, String lockName) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.lockName = lockName;
    }

    /**
     * 尝试获取分布式锁
     *
     * @param timeoutSec 锁的超时时间（秒），超过该时间锁将自动释放
     * @return 如果成功获取锁返回 true，否则返回 false
     */
    @Override
    public boolean tryLock(long timeoutSec) {
        // 获取当前线程 ID 作为锁的标识
        String threadId = UUID_PREFIX + Thread.currentThread().getId();
        Boolean isLock = stringRedisTemplate.opsForValue()
                .setIfAbsent(KEY_PREFIX + lockName, threadId, timeoutSec, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(isLock);
    }

    /**
     * 释放分布式锁
     * 通过执行 Lua 脚本原子性地删除锁键，确保解锁操作的线程安全
     * 只有持有锁的线程才能成功解锁，避免误删其他线程的锁
     */
    @Override
    public void unlock() {
        stringRedisTemplate.execute(
                UNLOCK_SCRIPT,
                Collections.singletonList(KEY_PREFIX + lockName),
                UUID_PREFIX + Thread.currentThread().getId()
        );
    };
   /* @Override
    public void unlock() {
        String threadId = UUID_PREFIX + Thread.currentThread().getId();
        String id = stringRedisTemplate.opsForValue().get(KEY_PREFIX + lockName);
        if (threadId.equals(id)) {
            stringRedisTemplate.delete(KEY_PREFIX + lockName);
        }

    */

}
