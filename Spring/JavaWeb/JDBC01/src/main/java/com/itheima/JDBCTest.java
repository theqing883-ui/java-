package com.itheima;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接
        String url = "jdbc:mysql://localhost:3306/spring_db";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        //获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //执行SQL语句
        int i = statement.executeUpdate("update tbl_account set name = 'Tom' where id = '1'");
        System.out.println("SQL语句的影响记录数"+i);
        //释放资源
        connection.close();
    }
}
