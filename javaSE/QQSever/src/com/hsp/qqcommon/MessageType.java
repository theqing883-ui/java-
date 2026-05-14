package com.hsp.qqcommon;

public interface MessageType {
    String MESSAGE_LOGIN_SUCCESS = "1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";//登录失败 public static final
    String MESSAGE_COMM_MES = "3";//普通信息
    String MESSAGE_GET_ONLINE_FRIEND = "4";//请求在线客户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线客户列表
    String MESSAGE_CLIENT_EXIT  = "6";//请求退出
    String MESSAGE_TO_ALL_MES = "7";//群发
}
