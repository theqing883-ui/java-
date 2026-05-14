package com.itheima.service;

import com.itheima.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional//开启事务
public interface BookService {
    /**
     *
     */
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);


    List<Book> getAll();

    Book getById(Integer id);
}
