package com.hsp.api.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);//监听9999端口
        System.out.println("监听 9999 端口");
        Socket socket = serverSocket.accept();
        System.out.println(socket.getClass());

        Reader reader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println(line);


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("我答应你！");
        bufferedWriter.newLine();//结束标记,要求对方读取方式为readLine()
        bufferedWriter.flush();//字符流，必须有flush()，否则进不去


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
