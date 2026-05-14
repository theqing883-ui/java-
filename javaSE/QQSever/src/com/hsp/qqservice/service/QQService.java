package com.hsp.qqservice.service;

/*客户端和服务端的类路径（包括包名）必须完全一致*/

import com.hsp.qqcommon.Message;
import com.hsp.qqcommon.MessageType;
import com.hsp.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class QQService {
    private ServerSocket serverSocket;
    /*建一个HashMap集合保存用户信息，用户号，密码等
    * 也可以使用ConcurrentHashMap 处理多并发的问题*/
    private static ConcurrentHashMap<String, User> validUser = new ConcurrentHashMap<>();
    static {//合法用户
        validUser.put("100",new User("100","123456"));
        validUser.put("200",new User("200","123456"));
        validUser.put("300",new User("300","123456"));
        validUser.put("400",new User("400","123456"));
        validUser.put("至尊宝",new User("至尊宝","123456"));
        validUser.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUser.put("菩提老祖",new User("菩提老祖","123456"));
    }
    private boolean checkUser(String username, String password) {//登录验证
        if (!validUser.containsKey(username)) {
            return false;
        }
        if (!password.equals(validUser.get(username).getPassword())) {
            return false;
        }
        return true;
    }
    public QQService() {
        try {
            /*serverSocket必须放到while循环的外面，因为while循环里面没有关闭serverSocket,999端口一直被占用着*/
            serverSocket = new ServerSocket(9999);
            System.out.println("服务端，正在监测9999端口，等待连接...");
            while (true) {/*需要随着监测端口,一旦链接成功就进行登录验证，验证成功后再启用其他线程做后续服务*/
                Socket socket = serverSocket.accept();
//                System.out.println("链接成功");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) ois.readObject();
                Message message = new Message();
                if (checkUser(user.getId(),user.getPassword())) {/*登录验证*/
                    /*登录成功*/
                    message.setMessType(MessageType.MESSAGE_LOGIN_SUCCESS);
                    oos.writeObject(message);
                    /*需要针对这个客户端开启一个线程 ServiceConnectClientThread*/
                    ServiceConnectClientThread serviceConnectClientThread = new ServiceConnectClientThread(socket, user);
                    serviceConnectClientThread.start();
                    /*开启的线程加入管理集合*/
                    ManageClientThread.addClientThread(user, serviceConnectClientThread);
                } else {
                    /*登录失败*/
                    System.out.println("用户:" + user.getId() + " pwd :" + user.getPassword() + "登录失败");
                    message.setMessType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                /*当服务端退出while循环不在监测后，关闭serverSocket*/
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new QQService();
    }

}
