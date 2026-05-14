package com.hmdp.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<ShopType> getShopType() {
        String key = RedisConstants.CACHE_SHOP_TYPE_KEY;

        // 1. 尝试从 Redis 获取全部列表
        // range(key, 0, -1) 表示获取从第一个到最后一个的所有元素
        // 返回类型是 List<String>，如果 key 不存在，返回空列表 [] (不会返回 null)
        List<String> typeJsonList = stringRedisTemplate.opsForList().range(key, 0, -1);
        // 2. 判断缓存是否命中
        if (typeJsonList != null && !typeJsonList.isEmpty()) {
            List<ShopType> ReList = new ArrayList<>();
            for (String json : typeJsonList) {
                ReList.add(JSONUtil.toBean(json, ShopType.class));
//                System.out.println(JSONUtil.toBean(json, ShopType.class));
            }
//            System.out.println("================================");
            return ReList;
        }
        // 3. 缓存未命中，查询数据库
        List<ShopType> dbTypeList = query().orderByAsc("sort").list();

        // 4. 写入 Redis 缓存
        if (dbTypeList != null && !dbTypeList.isEmpty()) {
            // 方案 A: 循环 rightPush (适合数据量不大，代码直观)
            for (ShopType type : dbTypeList) {
                // 建议转为 JSON 字符串存储，而不是 toString()，防止后续字段变更导致反序列化失败
                stringRedisTemplate.opsForList().rightPush(key, JSONUtil.toJsonStr(type));
//                System.out.println(type);
            }
            stringRedisTemplate.expire(key, RedisConstants.CACHE_SHOP_TYPE_TTL, TimeUnit.MINUTES);
//            System.out.println("=========================");
        }
        return dbTypeList;
    }
}
