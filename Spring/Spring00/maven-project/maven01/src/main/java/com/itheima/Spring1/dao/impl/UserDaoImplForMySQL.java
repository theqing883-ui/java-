package com.itheima.Spring1.dao.impl;

import com.itheima.Spring1.dao.UserDao;

public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById(int id) {
        System.out.println("MySQL正在删除数据");
    }
}
