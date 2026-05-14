package com.hsp.threadExit;
/*
线程终止
● 基本说明
1. 当线程完成任务后，会自动退出。
2. 还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式
* */
public class ThreadExit01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        System.out.println("main 线程休眠10秒");
        Thread.sleep(10*1000);
        // 通过使用变量来控制run方法退出的方式停止线程，即通知方式
        t.setLoop(false);


    }
}

class T extends Thread {
    private int i = 0;
    private boolean loop = true;

    @Override
    public void run() {

        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "  滴滴" + (++i));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}