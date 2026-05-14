package com.hsp.qqclient.service;

import com.hsp.qqcommon.Message;
import com.hsp.qqcommon.MessageType;
import com.hsp.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 完成用户验证、注册等服务
 */
public class UserClientService {
    private User u = new User();//可以在其他地方使用
    private Socket socket;//可以在其他地方使用

    public boolean chekUser(String userid, String pwd) {
        boolean flag = false;
        u.setId(userid);
        u.setPassword(pwd);
        try {
            //建立连接
            socket = new Socket(InetAddress.getLocalHost(), 9999);

            //写user信息
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            //读message信息
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if (MessageType.MESSAGE_LOGIN_SUCCESS.equals(ms.getMessType())) {
                /*登录成功，开启一个线程 ClientConnectServiceThread*/
                ClientConnectServiceThread ccst = new ClientConnectServiceThread(socket);//创建一个Client线程
                ccst.start();
                ManageClientConnectServiceThread.addClientConnectServiceThread(userid, ccst);//存入Client新端口的线程
                flag = true;//登录成功
            } else {
                /*登录失败, 无法与服务端建立通信，需要把开启的Socket关闭*/
                socket.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public void onlineFriedList() {
        //创建一个请求在线用户列表的Message MESSAGE_GET_ONLINE_FRIEND对象
        Message message = new Message();
        message.setMessType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getId());

        try {//发送
            /*通userID得到对应的线程，在通过线程，得到Socket,再通过socket得到OutputStream*/
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServiceThread.getClientConnectServiceThread(u.getId()).getSocket().getOutputStream());
            System.out.println("请求用户列表");
            oos.writeObject(message);//写入请求
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void Logout( String userid ) {
        /*创建一个message 对象*/
        Message message = new Message();
        message.setMessType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(userid);

        /*发送*/
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServiceThread.getClientConnectServiceThread(userid).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(userid + "退出");
            System.exit(0);//正常退出
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
