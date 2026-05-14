package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("save Book");
    }

    @Override
    public boolean update() {
        System.out.println("update Book");
        return true;
    }

    @Override
    public boolean delete() {
        System.out.println("delete Book");
        return true;
    }
}
