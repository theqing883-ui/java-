package com.hmdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class HmDianping03FlashSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmDianping03FlashSaleApplication.class, args);
    }

}
