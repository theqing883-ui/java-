package com.itheima.mapper;

import com.itheima.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//应用程序在运行时，会自动为该接口创建一个实现类对象（代理对象）,并且会自动将该实现类放进IoC容器-bean
public interface UserMapper {
    @Select("select id,name,money from tbl_account")
    List<Account> findAll();
}
