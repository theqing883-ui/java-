package com.hsp;
/*
继承Thread vs 实现Runnable的区别
1. 从java的设计来看，通过继承Thread或者实现Runnable接口来创建线程
    本质上没有区别，从jdk帮助文档我们可以看到Thread类本身就实现了Runnable接口
2. 实现Runnable接口方式更加适合多个线程共享一个资源的情况，
    并且避免了单继承的限制，建议使用Runnable
* */
public class Thread01 {
    public static void main(String[] args) {
        new MyThread().start();

        MyThread01 myThread01 = new MyThread01();
        Thread thread = new Thread(myThread01);
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Hello World");
            i++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (i == 10) {
                break;
            }
        }
    }
}
class MyThread01 implements Runnable {
    @Override
    public void run() {
        int j = 0;
        while (true) {
            System.out.println("Hi");
            j++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (j == 10) {
                break;
            }
        }
    }
}
