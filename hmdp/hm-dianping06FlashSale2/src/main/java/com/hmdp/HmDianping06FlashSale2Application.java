package com.hmdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*注解正是为了解决 Spring AOP 代理对象获取问题，
与后续代码中通过 AopContext.currentProxy()
调用方法的做法完全匹配。*/
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class HmDianping06FlashSale2Application {

    public static void main(String[] args) {
        SpringApplication.run(HmDianping06FlashSale2Application.class, args);
    }

}
