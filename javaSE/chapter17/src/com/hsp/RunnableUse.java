package com.hsp;

public class RunnableUse {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //RunnableUse没有start()方法
        Thread t1 = new Thread(dog);
        /*
        1.这里使用了静态代理模式
        * */
        t1.start();
    }
}

class Dog implements Runnable {
    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("旺旺~~" + (++times)
                    + "  " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (times == 10)
                break;
        }
    }
}