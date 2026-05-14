package com.hsp.api.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);//监听9999端口
        System.out.println("监听 9999 端口");
        Socket socket = serverSocket.accept();
        System.out.println(socket.getClass());

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {//一次读取1024个字节
            System.out.println(new String(buffer, 0, len));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我答应你！".getBytes());
        socket.shutdownOutput();//结束标记


        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
