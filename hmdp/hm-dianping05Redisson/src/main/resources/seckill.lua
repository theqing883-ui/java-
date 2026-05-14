---
--- Created by the_qing.
--- DateTime: 2026/4/1 10:39
---

-- 1. 参数列表：由 Java 调用时传入
local voucherId = ARGV[1]  -- 优惠券 ID
local userId = ARGV[2]     -- 用户 ID

-- 2. 拼接 Redis 中的 Key
local stockKey = 'seckill:stock:' .. voucherId  -- 存储库存的 Key (String 类型)
local orderKey = 'seckill:order:' .. voucherId  -- 存储已下单用户集合的 Key (Set 类型)

-- 3. 脚本逻辑执行
-- 3.1. 判断库存是否充足
-- redis.call 执行 get 命令，tonumber 将其转为数字进行比较
if (tonumber(redis.call('get', stockKey)) <= 0) then
    -- 库存不足，返回错误码 1
    return 1
end

-- 3.2. 判断用户是否已经下过单 (实现一人一单)
-- sismember 检查 Set 集合中是否存在该 userId
if (redis.call('sismember', orderKey, userId) == 1) then
    -- 用户已在集合中，说明是重复下单，返回错误码 2
    return 2
end

-- 4. 真正执行扣减和记录操作
-- 4.1. 扣减库存 (String 自减)
redis.call('incrby', stockKey, -1)

-- 4.2. 将用户 ID 保存到 Set 集合中，标记已购买
redis.call('sadd', orderKey, userId)

-- 5. 全部操作成功，返回 0 (通常约定 0 为成功)
return 0
