package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService {

    @Autowired

    private BookDao dao ;

    public void bookSave() {
        System.out.println("BookService save successful");
        this.dao.save();
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }
}
