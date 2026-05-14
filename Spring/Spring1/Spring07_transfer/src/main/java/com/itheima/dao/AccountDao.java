package com.itheima.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


public interface AccountDao {
    @Update("update tbl_account set money = money - #{money} where name = #{name}")
    void outCome(@Param("name") String name, @Param("money") double money);

    @Update("update tbl_account set money = money + #{money} where name = #{name}")
    void inCome(@Param("name") String name, @Param("money") double money);
}
