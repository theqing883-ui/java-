package com.hsp.api.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDownLoadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，正在监听9999,等待连接...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        String Filename = "";
        while ((len = inputStream.read(buffer)) != -1) {
            Filename += new String(buffer, 0, len);
        }
        System.out.println("文件名：" + Filename);
        String resFileName = " ";

        if("高山流水".equals(Filename)){
            resFileName = "E:\\java_code\\chapter21\\src\\高山流水.mp3";
        }else {
            resFileName = "E:\\java_code\\chapter21\\src\\无名.mp3";
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        byte[] buffer1 = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(buffer1);
        socket.shutdownOutput();

        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
    }
}
