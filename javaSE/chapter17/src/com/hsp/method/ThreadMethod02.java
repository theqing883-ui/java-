package com.hsp.method;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
线程常用方法
● 常用方法第二组
1. yield:线程的礼让。让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
2. join: 线程的插队，插队的线程一旦插队成功，则肯定先执行完插队的线程所有的任务

* */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        /**
         案例: 创建一个子线程, 每隔1s 输出 hello,输出 20次,主线程每隔1秒,
         输出 hi ,输出20次,要求:两个线程同时执行，当主线程输出5次后，
         就让子线程运行完毕，主线程再继续
         * */
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        MyThread01 myThread01 = new MyThread01();
//        myThread01.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("主线程[老三]吃包子~~" + i);
            Thread.sleep(1000);

            if (i == 5) {
                System.out.println("老大老二先吃");
                //join: 线程的插队
//                thread.join();
                //myThread01.join();

                //线程的礼让 资源充足的时候可能礼让不成功
                Thread.yield();// 静态方法调用者礼让
            }

        }


    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程[老大]吃包子" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class MyThread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程[老二]吃包子" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
