package com.hmdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class HmDianping08Application {

    public static void main(String[] args) {
        SpringApplication.run(HmDianping08Application.class, args);
    }

}
