package com.itheima.client;


import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP2 {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao dao1 = (BookDao)ctx.getBean("bookDao");
        BookDao dao2 = (BookDao)ctx.getBean("bookDao");
        System.out.println(dao1);
        System.out.println(dao2);
        dao1.save();
        ctx.close();

    }
}