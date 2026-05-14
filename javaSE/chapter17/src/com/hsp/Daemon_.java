package com.hsp;
/*
● 用户线程和守护线程
1. 用户线程：也叫工作线程，当线程的任务执行完或通知方式结束
2. 守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
3. 常见的守护线程：垃圾回收机制
* */
public class Daemon_ {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyDaemonThread());
        thread.setDaemon(true);//设置为守护线程
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("好好生活~~~" + (i + 1));
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("认真工作~~~~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
