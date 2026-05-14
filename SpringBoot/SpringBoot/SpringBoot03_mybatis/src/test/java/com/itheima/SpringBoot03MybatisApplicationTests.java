package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03MybatisApplicationTests {
    @Autowired
    BookService bookService;
    @Autowired
    BookDao bookDao;

    @Test
    public void bookServiceGetByIdTest() {
        System.out.println(bookService.getBookById(4));
    }
    @Test
    public void bookDaoGetByIdTest() {
        System.out.println(bookDao.getBookById(10));
    }

}
