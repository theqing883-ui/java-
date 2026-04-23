-- 获取锁中的线程标识 get key
--local id = redis.call('get',KEYS[1])
-- 比较线程标识与锁中标识是否对应
if( redis.call('get',KEYS[1]) == ARGV[1]) then
  --释放锁 del key
  return redis.call('del',KEYS[1])
end
return 0