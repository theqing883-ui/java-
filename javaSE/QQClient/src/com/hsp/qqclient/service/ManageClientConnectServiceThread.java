package com.hsp.qqclient.service;

import java.util.HashMap;


public class ManageClientConnectServiceThread {
    //key 存userid 但是感觉有问题，这个同一个id的线程集合，相同key会替换，待修改
    //value 存线程
   private static HashMap<String, ClientConnectServiceThread> map = new HashMap<>();

    public ManageClientConnectServiceThread(HashMap<String, ClientConnectServiceThread> map) {
        this.map = map;
    }
    public static void addClientConnectServiceThread(String userID, ClientConnectServiceThread clientConnectServiceThread) {
        map.put(userID,clientConnectServiceThread);
    }

    public static ClientConnectServiceThread getClientConnectServiceThread(String userID){
        return map.get(userID);
    }
}
