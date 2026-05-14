package com.itheima.Spring1.client;

import com.itheima.Spring1.dao.impl.UserDaoImplForMySQL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        //3.获取IoC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //4.获取bean
        UserDaoImplForMySQL dao1 = (UserDaoImplForMySQL) ctx.getBean("dao1");
        dao1.deleteById(1);
    }
}
