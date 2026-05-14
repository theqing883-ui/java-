package com.hsp.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();//本机
        System.out.println(localHost);
        System.out.println("====" + InetAddress.getByName("10.196.2.136"));

        InetAddress Host = InetAddress.getByName(localHost.getHostName());//主机名
        System.out.println(Host);

        InetAddress localHost2 = InetAddress.getByName("www.baidu.com");//域名
        System.out.println(localHost2);

        String address = Host.getHostAddress();//ip
        System.out.println(address);

        String hostName = Host.getHostName();//主机名或者域名
        System.out.println(hostName);
//        System.out.println(InetAddress.getName("10.196.2.136"));

    }
}
