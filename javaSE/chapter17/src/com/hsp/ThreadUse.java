package com.hsp;
/*
线程基本使用
● 创建线程的两种方式
在java中线程来使用有两种方法。
1. 继承Thread 类，重写run方法
2. 实现Runnable接口，重写run方法
* */
public class ThreadUse {
    public static void main(String[] args) {
        Cat cat = new Cat();
        //cat.run();//如此调用就是普通的调用方法，
        // 没有真的启动线程[Thread-0]，main会阻塞在这里

        cat.start();//启动线程，自动调用run()方法，
        //真正实现多线程的是 start()中调用的start0()方法
        /* 【并发】
        1.运行程序后，JVM会自动创建一个main线程
        2.main线程不会阻塞，不会等cat.start()【Thread-0】，执行结束后再执行
        3.它们会交替执行
        4.main线程结束，不代表进程结束
        * */
        for (int i = 0; i < 60; i++) {
            System.out.println("主线性");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
//1. 继承Thread 类，重写run方法
class Cat extends Thread {//可以当做线程使用
    int count = 0;
    @Override
    public void run() {
        while (true) {
            count++;
            System.out.println("喵喵~~~" + count + "  线程名" + Thread.currentThread().getName() );

            try {
                Thread.sleep(1000);//线程休眠1秒
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if(count == 80) {
                break;//当count == 10时退出while循环，也结束线程
            }

        }
    }
}