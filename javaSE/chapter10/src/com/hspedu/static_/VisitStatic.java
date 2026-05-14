package com.hspedu.static_;
/*
 1.什么是类变量
    类变量也叫静态变量 / 静态属性，是该类的所有对象共享的变量：
    所有对象访问它时，取值相同；
    任何对象修改它时，修改的是同一个变量。
 2.如何定义类变量
    定义语法（两种方式）：
    访问修饰符 static 数据类型 变量名；【推荐】
    static 访问修饰符 数据类型 变量名；
 3.如何访问类变量（以VisitStatic.java为例）
    方式 1：类名.类变量名【推荐】(说明：类变量是随着类加载(只会加载一次)而创建，所以不创建对象实例也可以访问)
    方式 2：对象名.类变量名
    （注：静态变量的访问修饰符的访问权限和范围，与普通属性一致）
* */
public class VisitStatic {
    public static void main(String[] args) {
        //类名.类变量名
        // 说明：类变量是随着类加载而创建，所以不创建对象实例也可以访问
        System.out.println(A.name);
        // 对象名.类变量名
        A a = new A();
        System.out.println(a.name);
    }
}

class A {
    //类变量
    public static String name = "王阳明新学";
}
