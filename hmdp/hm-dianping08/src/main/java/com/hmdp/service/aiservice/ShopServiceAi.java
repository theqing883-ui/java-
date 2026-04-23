package com.hmdp.service.aiservice;

import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceAi {
    @Autowired
    private ShopMapper shopMapper;

    //1.查询商家信息
    public Shop findShop(String shopName) {
        return shopMapper.findShop(shopName);
    }
}
