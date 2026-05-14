package com.hsp.method;
/*
线程常用方法
● 常用方法第一组
1. setName //设置线程名称，使之与参数name相同
2. getName //返回该线程的名称
3. start //使该线程开始执行；Java 虚拟机底层调用该线程的 start0方法
4. run //调用线程对象 run 方法；
5. setPriority //更改线程的优先级
6. getPriority //获取线程的优先级
7. sleep //在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）
8. interrupt //中断线程
* */

/*
韩顺平教育
线程常用方法
● 注意事项和细节
1. start 底层会创建新的线程，调用run，run 就是一个简单的方法调用，不会启动新
线程
2. 线程优先级的范围
3. interrupt，中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程
4. sleep:线程的静态方法，使当前线程休眠

java.lang.Thread
public static final int MAX_PRIORITY 10
public static final int NORM_PRIORITY 5
public static final int MIN_PRIORITY 1
* */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        MT mt = new MT();
        mt.setName("我");
        mt.setPriority(Thread.MIN_PRIORITY);
        mt.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }
        System.out.println(mt.getPriority());
        mt.interrupt();//引发一个中断异常，使mt提取结束休眠

    }
}
class MT extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                //
                System.out.println(Thread.currentThread().getName() + " 吃包子~~~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~~");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt 方法时，就会catch 一个 异常，可以加入自己的业务代码
                //InterruptedException 中断异常
                System.out.println(Thread.currentThread().getName() + " 被 interrupt了");
            }
        }
    }
}
