package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 正确写法
@RestController
/*
@Controller
@ResponseBody
* */
@RequestMapping("/books")
public class BookController {
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("保存成功" + book);
        return "module:BookSave success";
    }

    @GetMapping
    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Spring MVC");
        book1.setType("SSM");
        book1.setDescription("要好好学");

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("Spring");
        book2.setType("SSM");
        book2.setDescription("Spring家族的基础");

        books.add(book1);
        books.add(book2);

        return books;
    }
}
