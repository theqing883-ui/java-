package com.hsp.qqclient.service;

import com.hsp.qqclient.utils.Utility;
import com.hsp.qqcommon.Message;
import com.hsp.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServiceThread extends Thread {
    private Socket socket;

    public ClientConnectServiceThread(Socket socket) throws IOException {
        this.socket = socket;
//        this.ois = new ObjectInputStream(socket.getInputStream());
//        this.oos = new ObjectOutputStream(socket.getOutputStream());
    }
//    ObjectInputStream ois ;
//    ObjectOutputStream oos;

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        /*需要随时等待接收服务端的信息*/
        while (true) {
            try {
                System.out.println("客户端 等待从服务端发送的消息...\n\n");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();
                /*接收到以后可以进行后续处理*/
                if (ms.getMessType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    String[] onlineFriendList = ms.getContent().split(" ");
                    System.out.println("\n==========在线用户列表==========");
                    for (int i = 0; i < onlineFriendList.length; i++) {
                        System.out.println("用户：" + onlineFriendList[i]);
                    }
                } else if (MessageType.MESSAGE_COMM_MES.equals(ms.getMessType())) {
                    System.out.println("\n\n" + ms.getSender() + "对" + ms.getReceiver() + "说: \n" + ms.getContent());
                    /*回信*/
//                    System.out.println("回信内容：");
//                    String answer = Utility.readString(100);
//                    System.out.println(ms.getReceiver() + "说" + answer);
//                    new MessageClientService().sendMessageToOne(ms.getReceiver(), ms.getSender(), answer);
                } else if (MessageType.MESSAGE_TO_ALL_MES.equals(ms.getMessType())) {
                    System.out.println("\n\n" + ms.getSender() + "对大家说：\n" + ms.getContent());
                }
                else {
                    System.out.println("==========其他类型信息==========");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
