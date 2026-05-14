package com.hsp.qqcommon;

import java.io.Serializable;
/**
 * 信息类
 * */
public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    private String sender;
    private String receiver;
    private String content;
    private String MessType;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessType() {
        return MessType;
    }

    public void setMessType(String messType) {
        MessType = messType;
    }
}
