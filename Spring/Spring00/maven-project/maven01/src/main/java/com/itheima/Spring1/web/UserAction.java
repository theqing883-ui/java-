package com.itheima.Spring1.web;

import com.itheima.Spring1.service.UserService;
import com.itheima.Spring1.service.impl.UserServiceImpl;

/**
 * 表示层
 */
public class UserAction {
    private UserService userService = new UserServiceImpl();

    /*删除用户信息的请求*/
    public void deleteRequest() {
        userService.deleteUser();
    }
}
