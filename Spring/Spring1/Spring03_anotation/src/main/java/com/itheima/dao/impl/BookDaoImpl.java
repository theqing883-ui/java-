package com.itheima.dao.impl;


import com.itheima.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("bookDao")
@Repository("bookDao")
@Scope("prototype")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("bok dao 保存数据");
    }
    public BookDaoImpl() {

    }

}
