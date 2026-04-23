package com.hmdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true) // 关键点：暴露代理对象
@SpringBootApplication
public class HmDianping05RedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmDianping05RedissonApplication.class, args);
    }

}
