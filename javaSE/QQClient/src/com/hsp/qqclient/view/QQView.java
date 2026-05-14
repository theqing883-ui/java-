package com.hsp.qqclient.view;

import com.hsp.qqclient.service.MessageClientService;
import com.hsp.qqclient.service.UserClientService;
import com.hsp.qqclient.utils.Utility;

/**
 * 菜单界面
 */
public class QQView {
    private boolean loop = true;
    private String key;
    private UserClientService userClientService = new UserClientService();//用于登录服务器注册用户等
    private MessageClientService messageClientService = new MessageClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("退出网络通信系统...");

    }

    private void mainMenu() {
        while (loop) {
            System.out.println("==========欢迎登录网络通信系统==========");
            System.out.println("\t\t1 登录系统");
            System.out.println("\t\t9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1": {
                    System.out.print("请输入用户号：");
                    String UserId = Utility.readString(50);
                    System.out.print("请输入密 码：");
                    String pwd = Utility.readString(50);
                    /*
                     * 与服务器通信判断是否登录成功
                     * */
                    if (userClientService.chekUser(UserId, pwd)) {
                        System.out.println("欢迎 " + UserId + " 登录");

                        while (loop) {
                            System.out.println("==========网络通信系统二级菜单(用户" + UserId + ")==========");
                            System.out.println("\t\t1 显示在线用户列表");
                            System.out.println("\t\t2 群发消息");
                            System.out.println("\t\t3 私发消息");
                            System.out.println("\t\t4 发送文件");
                            System.out.println("\t\t9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1": {
                                    System.out.println("显示在线用户列表");
                                    userClientService.onlineFriedList();
                                    try {
                                        Thread.sleep(500); // 等待0.5秒让服务器响应
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }
                                case "2": {
//                                    System.out.println("群发消息");
                                    System.out.print("请输入对大家说的话：");
                                    String content = Utility.readString(100);
                                    /*调用群发方法*/
                                    messageClientService.sendMessageToALL(UserId, content);
                                    break;
                                }
                                case "3": {
//                                    System.out.println("私发信息");
                                    System.out.print("请输入私聊用户：");
                                    String receiver = Utility.readString(50);
                                    System.out.print("请输入私聊的内容：");
                                    String content = Utility.readString(100);
                                    /*调用私聊方法*/
                                    messageClientService.sendMessageToOne(UserId, receiver, content);
                                    break;
                                }
                                case "4": {
                                    System.out.println("发送文件");
                                    break;
                                }
                                case "9": {
                                    loop = false;
                                    userClientService.Logout(UserId);
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("密码或用户号不正确");
                    }
                    break;
                }
                case "9": {
                    /*还未登录（还未建立连接），此时退出不需要和服务端通信*/
                    loop = false;
                    break;
                }
            }
        }
    }

}
