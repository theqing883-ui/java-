package com.itheima.service;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private BookService service;

    @Test
    public void save() {
        Book book = new Book();
        book.setType("11");
        System.out.println( service.save(book) );
    }
    @Test
    public void update() {
        Book book = new Book();
        System.out.println(service.update(book));

    }
    @Test
    public void delete() {
        System.out.println(service.delete(3) );
    }
    @Test
    public void getById() {
        System.out.println(service.getById(4));
    }
    @Test
    public void getAll() {
        System.out.println(service.getAll());
    }
}
