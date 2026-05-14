package com.hsp.api.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接到: " + socket.getRemoteSocketAddress());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我们一起去看雪！".getBytes());



        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
