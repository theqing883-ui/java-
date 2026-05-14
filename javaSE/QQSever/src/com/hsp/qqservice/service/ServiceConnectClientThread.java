package com.hsp.qqservice.service;

import com.hsp.qqcommon.Message;
import com.hsp.qqcommon.MessageType;
import com.hsp.qqcommon.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServiceConnectClientThread extends Thread {
    private Socket socket;
    private User user;

    public ServiceConnectClientThread(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            /*保存某个客户端的通信*/
            System.out.println("服务端和用户" + user.getId() + "正在通信");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                /*对message的后续处理*/
                if (message.getMessType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    System.out.println(message.getSender() + "正在请求在线用户列表...");
                    /*返回在线用户列表*/
                    String onlineUser = ManageClientThread.getOnlineUser();//获取在线用户
                    Message message1 = new Message();
                    message1.setMessType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setReceiver(message.getSender());
                    /*返回用户列表*/
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                    oos.flush();
                } else if (message.getMessType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + "退出系统");
                    /*移除即将退出的线程*/
                    ManageClientThread.removeClientThread(message.getSender());
                    socket.close();
                    break;
                } else if (message.getMessType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println(message.getSender() + "发起私聊" + message.getReceiver());
                    ServiceConnectClientThread clientThread = ManageClientThread.getServiceConnectClientThread(message.getReceiver());
                    ObjectOutputStream oos = new ObjectOutputStream(clientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                    oos.flush();
                } else if (message.getMessType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    /*群发信息*/
                    HashMap<String, ServiceConnectClientThread> map = ManageClientThread.getMap();
                    Iterator<String> iterator = map.keySet().iterator();
                    /*遍历map */
                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        if (!(key.equals(message.getSender()))) {//不发给自己
                            ObjectOutputStream oos = new ObjectOutputStream(map.get(key).getSocket().getOutputStream());
                            oos.writeObject(message);
                            oos.flush();
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
