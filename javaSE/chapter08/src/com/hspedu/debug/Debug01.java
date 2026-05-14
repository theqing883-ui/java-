package com.hspedu.debug;
/*
 一个实际需求
    1.开发中新手排查错误时，老程序员会建议用断点调试：逐步查看源码执行过程，从而发现错误。
    2.重要提示：断点调试过程是运行状态，以对象的运行类型来执行。
  断点调试介绍
    定义：在程序某一行设置断点，调试时程序运行到该行会暂停，可逐步向下调试，查看变量当前值；若出错，可定位到错误代码行并分析解决 Bug。
    作用 1：程序员排查错误的手段。
    作用 2：帮助查看 Java 底层源代码的执行过程，提升 Java 水平。
* */
/*
断点调试的快捷键
    F7（跳入）：跳入方法内
    alt + shift + F7:强制进入方法
    F8（跳过）：逐行执行代码
    shift+F8（跳出）：跳出方法
    F9（resume）：执行到下一个断点
* */
public class Debug01 {
    public static void main(String[] args) {
        //演示逐行执行代码(F8)
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("i = " + i);
            System.out.println("sum = " + sum);
        }
        System.out.println("退出for.....");
    }
}
