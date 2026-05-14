package com.itheima.client;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao dao1 = (BookDao)ctx.getBean("dao");
        BookDao dao2 = (BookDao)ctx.getBean("dao");
        System.out.println(dao1);
        System.out.println(dao2);
        dao1.save();
        System.out.println("============service==============");
        BookService service = (BookService)ctx.getBean("service");
        service.bookSave();
    }
}