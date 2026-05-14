package com.kama;


import com.kama.service.UserService;
import com.minispring.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.doSomething();
    }

}
