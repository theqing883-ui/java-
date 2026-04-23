package com.hmdp;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Shop;
import com.hmdp.entity.User;
import com.hmdp.service.IUserService;
import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.UserToUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SpringBootTest
class HmDianping06FlashSale2ApplicationTests {
    @Autowired
    private ShopServiceImpl shopService;
    @Resource
    private IUserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void saveShopToRedisTest() throws InterruptedException {
        shopService.saveShopToRedis(1L, 20L);
    }

    @Test
    void testCreateTokens() throws IOException {
        // 1. 获取用户列表（建议先去数据库确认一下 tb_user 表里是否有足够的数据）
        // 这里取 1000 个用户进行压测模拟
        List<User> users = userService.list(new QueryWrapper<User>().last("limit 1000"));

        // 2. 准备文件写入流（路径建议改为你电脑上存在的文件夹）
        String filePath = "E:\\java_code\\hmdp\\tokens.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (User user : users) {
                UserDTO userDTO = UserToUserDTO.userToUserDTO(user);
                Map<String, Object> userDtOMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),                      // 目标容器：新的 HashMap 接收转换结果
                        CopyOptions.create()                  // 转换配置选项
                                .setIgnoreNullValue(true)         //   ├─ 忽略值为 null 的字段（不放入 Map）
                                .setFieldValueEditor(             //   └─ 字段值编辑器（自定义处理逻辑）
                                        (fieldKey, fieldValue) -> //      ├─ Lambda 表达式：(字段名, 字段值)
                                                fieldValue.toString()         //       └─ 将所有值统一转为 String 类型
                                ));
                String token = UUID.randomUUID().toString();
                stringRedisTemplate.opsForHash().putAll(RedisConstants.LOGIN_USER_KEY + token, userDtOMap);
                //设置有效期 这个有效期是指用户超过这个时间不访问这个网页，用户信息将会从Redis里面删除，用户需要重新登陆
                stringRedisTemplate.expire(RedisConstants.LOGIN_USER_KEY + token, RedisConstants.LOGIN_USER_TTL, TimeUnit.DAYS);

                // 6. 将生成的 token 写入 txt 文件，每行一个
                writer.write(token);
                writer.newLine();
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Token 导出成功！共生成：" + users.size() + " 个。文件位置：" + filePath);
    }

    /**
     * 加载店铺数据到Redis Geo
     * <p>
     * 从数据库中查询所有店铺信息，按店铺类型分组后，
     * 将每种类型的店铺位置信息（经纬度）存储到Redis的Geo结构中，
     * 用于后续基于地理位置的店铺搜索功能。
     * </p>
     */
    @Test
    void LoadShopData() {
        List<Shop> list = shopService.list();
        
        // 按店铺类型ID进行分组
        Map<Long, List<Shop>> map = list.stream().collect(Collectors.groupingBy(Shop::getTypeId));

        for (Map.Entry<Long, List<Shop>> entry : map.entrySet()) {
            System.out.println( entry.getKey() + "对应" + entry.getValue());
            String key = "shop:geo:" + entry.getKey();
            List<Shop> shops = entry.getValue();
            
            // 构建Redis Geo位置信息列表
            ArrayList<RedisGeoCommands.GeoLocation<String>> geoLocations = new ArrayList<>(shops.size());
            for (Shop shop : shops) {
                geoLocations.add(new RedisGeoCommands.GeoLocation<>(
                        shop.getId().toString(),
                        new Point(shop.getX(), shop.getY())
                ));
            }
            
            // 将店铺位置数据批量添加到Redis Geo中
            stringRedisTemplate.opsForGeo().add(key, geoLocations);
        }
    }

}
