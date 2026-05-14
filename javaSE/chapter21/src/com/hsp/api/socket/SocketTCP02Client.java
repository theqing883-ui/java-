package com.hsp.api.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接到: " + socket.getRemoteSocketAddress());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我们一起去看雪！".getBytes());
        socket.shutdownOutput();//结束标记


        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }

        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
