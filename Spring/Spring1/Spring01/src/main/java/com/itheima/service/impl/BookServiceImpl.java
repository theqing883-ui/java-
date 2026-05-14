package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDao dao ;

    public void bookSave() {
        System.out.println("BookService save successful");
        this.dao.save();
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }
}
