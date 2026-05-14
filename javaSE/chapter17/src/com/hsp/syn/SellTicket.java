package com.hsp.syn;

/*
Synchronized
● 线程同步机制
1. 在多线程编程，一些敏感数据不允许多个线程同时访问，此时就使用同步访问技术，
    保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性。
2. 也可以这里理解：线程同步，即当有一个线程在对内存进行操作时，
    其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，
    其他线程才能对该内存地址进行操作。
* */

/*
Synchronized
● 同步具体方法-Synchronized
1. 同步代码块
    synchronized (对象) { //得到对象的锁，才能操作同步代码
        //需要被同步代码；
    }
2. synchronized还可以放在 方法 声明中，表示整个方法为同步方法
    public synchronized void m (String name){
                 //需要被同步的代码
    }
* */


/*
1. Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性。
2. 每个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。
3. 关键字synchronized来与对象的互斥锁联系。当某个对象用synchronized修饰时，表明该对象在任一时刻只能由一个线程访问
4. 同步的局限性：导致程序的执行效率要降低
5. 同步方法（非静态的）的锁可以是this，也可以是其他对象(要求是同一个对象)
6. 同步方法（静态的）的锁为当前类本身。
* */


/*
● 注意事项和细节
1. 同步方法如果没有使用static修饰：默认锁对象为this
2. 如果方法使用static修饰，默认锁对象:当前类.class
3. 实现的落地步骤:
- 需要先分析上锁的代码
- 选择同步代码块或同步方法 ，推荐同步代码块
- 要求多个线程的锁对象为同一个即可!
* */
public class SellTicket {
    public static void main(String[] args) {
//        System.out.println("===使用实现Thread方式来售票=====");
//        // 测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        // 这里我们会出现超卖..
//        sellTicket01.start(); // 启动售票线程
//        sellTicket02.start(); // 启动售票线程
//        sellTicket03.start(); // 启动售票线程

        System.out.println("===使用实现接口方式来售票=====");
        //这里做了线程同步处理
        SellTicket02 sellTicket02_2 = new SellTicket02();
        new Thread(sellTicket02_2).start(); // 第1个线程-窗口
        new Thread(sellTicket02_2).start(); // 第2个线程-窗口
        new Thread(sellTicket02_2).start(); // 第3个线程-窗口
        /*
        Thread-0线程进入 sell02() 后会持有锁50ms（Thread.sleep(50)）
        当它退出 sell02() 释放锁后，立即又进入下一次循环，再次尝试获取锁
        由于锁释放和重新获取之间的时间间隔极短，同一个线程有很大概率再次抢到锁
        * */
        /*
        1.synchronized的锁lock锁住的是任意的同一个对象或者类[static 时只能锁类]，
        只要需要同步的线程都是在争夺这个对象就行
        2.通过继承Thread 实现线程的不能用锁住this实现同步，因为每个线程都对应不同的this
        * */
    }
}

// 使用Thread方式
class SellTicket01 extends Thread {
    private static int ticketNum = 100; // 让多个线程共享ticketNum
    private static boolean loop = true;

    // 使用synchronized实现线程同步,必须改为static，让所有对象共用一个run方法
    /*
    1.public static synchronized void sell() {} 这里锁住的是当前类本身
    * */
    public static /*synchronized*/ void sell() {//这里锁住的只能是当前类本身
        synchronized (SellTicket01.class) {//这里锁住的只能是当前类本身
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName()
                    + " 售出一张票" + " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}


// 实现接口方式Runnable
class SellTicket02 implements Runnable {
    Object object = new Object();
    private int ticketNum = 100; // 让多个线程共享ticketNum
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            sell02();
        }
    }

    // 使用synchronized实现线程同步 ，同一时刻，只能有一个线程调用sell方法
    /*
    1.public synchronized void sell02(){} 这里锁住的是当前对象的(this) 同步方法
    2.也可以将锁加在代码块上 同步代码块
    * */
    public /*synchronized*/ void sell02() {
        //synchronized (this) {//这里锁住的是当前对象的(this)
        synchronized (object) {//这里锁住的是object
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("窗口 " + Thread.currentThread().getName() +
                    " 售出一张票" + " 剩余票数=" + (--ticketNum));
        }
    }
}
