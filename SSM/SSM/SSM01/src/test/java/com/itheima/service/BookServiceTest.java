package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)//
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void serviceSaveTest() {
        Book book = new Book();
        book.setType("音乐");
        book.setName("小提琴");
        book.setDescription("很有艺术气息");
        bookService.save(book);
    }

    @Test
    public void serviceGetAllTest() {
        System.out.println(bookService.getAll());
    }

    @Test
    public void serviceGetByIdTest() {
        System.out.println(bookService.getById(2));
    }
}
