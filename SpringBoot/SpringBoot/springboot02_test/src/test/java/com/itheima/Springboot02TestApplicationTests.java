package com.itheima;

import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02TestApplicationTests {
    @Autowired
    private BookService bookService;

    @Test
    public void saveBookTest() {
        bookService.saveBook();
    }

}
