package com.hsp;

public class homework02 {
    public static void main(String[] args) {
        MyThread_ myThread = new MyThread_();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();

    }
}

class MyThread_ implements Runnable {
    private int total = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (total <= 0) {//先判断再进行后面的操作
                    System.out.println("余额不足");
                    break;
                }
                total -= 1000;
                System.out.println(Thread.currentThread().getName()
                        + "取出" + 1000 + "余下" + total);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
