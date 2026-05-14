package com.itheima.Spring1.dao;

/**
 * 持久层
 * 负责用户数据的增删改查
 */
public interface UserDao {
    /*根据ID删除数据*/
    void deleteById(int id);
}
