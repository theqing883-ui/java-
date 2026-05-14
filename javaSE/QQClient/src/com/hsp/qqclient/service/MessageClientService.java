package com.hsp.qqclient.service;

import com.hsp.qqcommon.Message;
import com.hsp.qqcommon.MessageType;
import com.hsp.qqcommon.User;

import java.io.IOException;
import java.io.ObjectOutputStream;

/*信息服务类*/
public class MessageClientService {
    /*群发消息*/
    public void sendMessageToALL(String sender,String content   ) {
        Message message = new Message();
        message.setSender(sender);
        message.setMessType(MessageType.MESSAGE_TO_ALL_MES);
        message.setContent(content);

        /*发送*/
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServiceThread.getClientConnectServiceThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(sender + "对大家说\n" + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /*私聊方法*/
    public void sendMessageToOne(String sender, String receiver, String content) {
        Message message = new Message();
        message.setMessType(MessageType.MESSAGE_COMM_MES);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        /*发送*/
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServiceThread.getClientConnectServiceThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(sender + "对" + receiver + "说\n" + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
