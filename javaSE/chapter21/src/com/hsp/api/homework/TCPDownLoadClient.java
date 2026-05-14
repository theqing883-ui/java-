package com.hsp.api.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPDownLoadClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名：");
        String fileName = scanner.next();
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // InetAddress.getLocalHost()  DESKTOP-H5S6JKV/10.196.2.136
//        System.out.println(InetAddress.getLocalHost());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(fileName.getBytes());
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String str = "E:\\java_code\\chapter21\\" + fileName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(str));
        bos.write(bytes);

        bos.close();
        bis.close();
        outputStream.close();
        socket.close();

    }
}
