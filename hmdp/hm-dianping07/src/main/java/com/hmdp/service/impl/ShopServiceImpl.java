package com.hmdp.service.impl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.hmdp.utils.CacheClient;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.RedisData;
import com.hmdp.utils.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {
    private static final ExecutorService CACHE_REBUILD_EXECUTOR
            = Executors.newFixedThreadPool(10);

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private CacheClient cacheClient;

    @Override
    public Result queryById(Long id) {
        //缓存穿透
        //id2 -> getById(id2) 等价于 this::getById
//        Shop shop =  cacheClient.
//                queryWithPassThrough(RedisConstants.CACHE_SHOP_KEY, id,Shop.class, this::getById,RedisConstants.CACHE_SHOP_TTL,TimeUnit.MINUTES);
        // 互斥锁解决缓存击穿
//        Shop shop = queryWithCacheMutex(id);
        // 逻辑过期解决缓存击穿
        Shop shop = queryWithLogicalExpire(id);
        if (shop == null) {
            return Result.fail("商铺不存在！");
        }
        return Result.ok(shop);
    }

    public Shop queryWithLogicalExpire(Long id) {
        String key = RedisConstants.CACHE_SHOP_KEY;
        String lockKey = RedisConstants.LOCK_SHOP_KEY;
        // 查询Redis中商铺信息
        String redisDataJSON = stringRedisTemplate.opsForValue().get(key + id);
        if (StrUtil.isBlank(redisDataJSON)) {
            // 未查询到
            // 一般在举行活动前会把，活动的热点key全部导入Redis,未命中说明，这个id不属于本次活动，直接返回null
            return cacheClient.queryWithPassThrough2(redisDataJSON,key, id,Shop.class,
                          this::getById,RedisConstants.CACHE_SHOP_TTL,TimeUnit.MINUTES);// 缓存穿透
        }
        //查询到后判断过期时间
        RedisData redisData = JSONUtil.toBean(redisDataJSON, RedisData.class);
        JSONObject data = (JSONObject) redisData.getData();
        Shop shop = JSONUtil.toBean(data, Shop.class);
        LocalDateTime expireTime = redisData.getExpireTime();
        if (expireTime.isAfter(LocalDateTime.now())) {
            // 未过期
            return shop;
        }
        // 已经过期后，需要去获取锁
        boolean flag = tryLock(lockKey + id);
        if (flag) {
            try {
                // 再次判断Redis中数据是否过期
                redisDataJSON = stringRedisTemplate.opsForValue().get(key + id);
                if (StrUtil.isNotBlank(redisDataJSON)) {
                    redisData = JSONUtil.toBean(redisDataJSON, RedisData.class);
                    data = (JSONObject) redisData.getData();
                    shop = JSONUtil.toBean(data, Shop.class);
                    expireTime = redisData.getExpireTime();
                    if (expireTime.isAfter(LocalDateTime.now())) {
                        //未过期,就直接释放锁，返回
                        unLock(lockKey + id);
                        return shop;
                    }
                }
                // 还是过期，开启新线程进行重建
                CACHE_REBUILD_EXECUTOR.submit(() -> {
                    try {
                        this.saveShopToRedis(id, 20L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        unLock(lockKey + id);
                    }
                });
            } catch (Exception e) {
                unLock(lockKey + id);
                throw new RuntimeException(e);
            }

        }
        // 返回过期商铺信息
        return shop;
    }

    public Shop queryWithCacheMutex(Long id) {
        String key = RedisConstants.CACHE_SHOP_KEY;
        long TTL = RedisConstants.CACHE_SHOP_TTL;
        String lockKey = RedisConstants.LOCK_SHOP_KEY;
        //先查询Redis中商铺信息
        String shopJson = stringRedisTemplate.opsForValue().get(key + id);
        if (StrUtil.isNotBlank(shopJson)) {
            //查询到信息直接返回
            return JSONUtil.toBean(shopJson, Shop.class);
        }
        //是否命中空值
        if (shopJson != null) {
            //是空值直接返回
            return null;
        }
        try {
            boolean flag = tryLock(lockKey + id);
            if (!flag) {
                //未拿到锁
                Thread.sleep(50);
                return queryWithCacheMutex(id);
            }
            //已经拿到锁，再次查询Redis中商铺信息
            shopJson = stringRedisTemplate.opsForValue().get(key + id);
            if (StrUtil.isNotBlank(shopJson)) {
                //查询到信息直接返回
                return JSONUtil.toBean(shopJson, Shop.class);
            }

            //Redis还是未查询到，再查数据库
            Shop shop = getById(id);
            Thread.sleep(200);
            if (shop == null) {
                //数据库中也没有
                stringRedisTemplate.opsForValue().
                        set(key + id, "", TTL + RandomUtil.randomInt(6), TimeUnit.MINUTES);
                return null;
            }
            //数据库中查到了,先保存到Redis，再返回
            stringRedisTemplate.opsForValue().
                    set(key + id, JSONUtil.toJsonStr(shop), TTL + RandomUtil.randomInt(6), TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            unLock(lockKey + id);
        }
        return null;
    }

    //重建redis，shop封装为，带有过期时间数据
    public void saveShopToRedis(Long id, Long expireMinute) throws InterruptedException {
        Shop shop = getById(id);
        RedisData  redisData = new RedisData();
        redisData.setData(shop);
        redisData.setExpireTime(LocalDateTime.now().plusMinutes(expireMinute));
        Thread.sleep(200);
        stringRedisTemplate.opsForValue().
                set(RedisConstants.CACHE_SHOP_KEY + id, JSONUtil.toJsonStr(redisData));
    }

    //获取锁
    public boolean tryLock(String key) {
        Boolean b = stringRedisTemplate.opsForValue().
                setIfAbsent(key, "1", RedisConstants.LOCK_SHOP_TTL, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(b);

    }

    //释放锁
    public void unLock(String key) {
        Boolean delete = stringRedisTemplate.delete(key);
    }

    /*public Shop queryWithCachePass(Long id) {
        String key = RedisConstants.CACHE_SHOP_KEY;
        long TTL = RedisConstants.CACHE_SHOP_TTL;
        //先查询Redis中商铺信息
        String shopJson = stringRedisTemplate.opsForValue().get(key + id);
        if (StrUtil.isNotBlank(shopJson)) {
            //查询到信息直接返回
            Shop shop = JSONUtil.toBean(shopJson, Shop.class);
            return shop;
        }
        //是否命中空值
        if (shopJson != null) {
            return null;
        }
        //Redis未查询到，再查数据库
        Shop shop = getById(id);
        if (shop == null) {
            //数据库中也没有
            stringRedisTemplate.opsForValue().set(key + id, "", TTL + RandomUtil.randomInt(6), TimeUnit.MINUTES);
            return null;
        }
        //数据库中查到了,先保存到Redis，再返回
        stringRedisTemplate.opsForValue().set(key + id, JSONUtil.toJsonStr(shop), TTL + RandomUtil.randomInt(6), TimeUnit.MINUTES);
        return shop;
    }
*/
    @Override
    @Transactional
    //缓存主动更新
    public Result update(Shop shop) {
        if (shop.getId() == null) {
            return Result.fail("id不能为空！");
        }
        //操作数据库
        updateById(shop);
        //删除缓存
        stringRedisTemplate.delete(RedisConstants.CACHE_SHOP_KEY + shop.getId());
        return Result.ok();
    }

    /**
     * 根据类型查询店铺列表（支持地理位置排序）
     * <p>
     * 当提供经纬度坐标时，从Redis Geo中查询指定范围内的店铺，按距离排序并返回距离信息；
     * 当不提供坐标时，仅根据店铺类型进行普通分页查询。
     * </p>
     *
     * @param typeId 店铺类型ID
     * @param current 当前页码，从1开始
     * @param x 经度坐标，用于计算距离和排序，可为null
     * @param y 纬度坐标，用于计算距离和排序，可为null
     * @return Result对象，包含店铺信息列表，若提供坐标则每个店铺包含距离字段
     */
    @Override
    public Result queryShopByType(Integer typeId, Integer current, Double x, Double y) {
        //不进行坐标查询
        if (x == null || y == null) {
            // 根据类型分页查询
            Page<Shop> page = query()
                    .eq("type_id", typeId)
                    .page(new Page<>(current, SystemConstants.DEFAULT_PAGE_SIZE));
            // 返回数据
            return Result.ok(page.getRecords());
        }

        //计算分页参数
        int from = (current - 1) * SystemConstants.DEFAULT_PAGE_SIZE;
        int end = current * SystemConstants.DEFAULT_PAGE_SIZE;

        // 从Redis Geo中查询指定半径内的店铺，并按距离排序
        String key = RedisConstants.SHOP_GEO_KEY + typeId;
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = stringRedisTemplate.opsForGeo()
                .search(
                        key,
                        GeoReference.fromCoordinate(x, y),
                        new Distance(5000),//单位m
                        RedisGeoCommands.GeoSearchCommandArgs.newGeoSearchArgs().includeDistance().limit(end)
                );
        if (results == null) {
            return Result.ok(Collections.emptyList());
        }
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> list = results.getContent();
        if (list.size() <= from) {
            // 如果跳过的起始点已经超过了结果总量，直接返回空
            return Result.ok(Collections.emptyList());
        }
        ArrayList<Long> shopIds = new ArrayList<>(list.size());
        Map<String,Distance> distanceMap = new HashMap<>(list.size());

        // 跳过前面的记录实现分页，提取店铺ID和距离信息
        list.stream().skip(from).forEach(result -> {

            String shopIdStr = result.getContent().getName();
            shopIds.add(Long.valueOf(shopIdStr));
            Distance distance = result.getDistance();
            distanceMap.put(shopIdStr,distance);
        });

        // 按照Geo查询结果的顺序从数据库批量查询店铺详细信息
        String idStr = StrUtil.join(",", shopIds);
        List<Shop> shops = query().in("id", shopIds).last("ORDER BY FIELD ( ID ," + idStr + ")").list();

        // 为每个店铺设置距离信息
        for (Shop shop :shops){
            shop.setDistance(distanceMap.get(shop.getId().toString()).getValue());
        }
        return Result.ok(shops);
    }
}
