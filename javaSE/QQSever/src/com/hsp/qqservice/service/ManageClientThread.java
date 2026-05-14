package com.hsp.qqservice.service;

import com.hsp.qqcommon.User;

import java.util.HashMap;

public class ManageClientThread {
    /*key存用户id，value存用户对应的ServiceConnectClientThread*/
    private static HashMap<String, ServiceConnectClientThread> map = new HashMap<>();

    public static HashMap<String, ServiceConnectClientThread> getMap() {
        return map;
    }

    public static void addClientThread(User user, ServiceConnectClientThread serviceConnectClientThread) {//存入ClientThread
        map.put(user.getId(), serviceConnectClientThread);
    }

    public static void removeClientThread(String  userId) {//移除线程
        map.remove(userId);
    }

    public static ServiceConnectClientThread getServiceConnectClientThread(String userId) {
        return map.get(userId);
    }
    public static String getOnlineUser() {
        String onlineUser = "";
        for(String user : map.keySet()) {
            onlineUser += user + " ";
        }
        return onlineUser;
    }
}
