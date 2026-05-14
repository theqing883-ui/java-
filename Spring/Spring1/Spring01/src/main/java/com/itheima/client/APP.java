package com.itheima.client;

import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;

public class APP {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.bookSave();
    }
}
