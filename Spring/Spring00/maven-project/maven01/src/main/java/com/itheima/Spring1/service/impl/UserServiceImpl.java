package com.itheima.Spring1.service.impl;

import com.itheima.Spring1.dao.UserDao;
import com.itheima.Spring1.dao.impl.UserDaoImplForMySQL;
import com.itheima.Spring1.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImplForMySQL();

    @Override
    public void deleteUser() {
        System.out.println("调用UserDaoImplForMySQL，进行数据删除");
        dao.deleteById(1);
    }
}
