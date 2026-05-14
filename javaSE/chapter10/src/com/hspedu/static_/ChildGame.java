package com.hspedu.static_;
/*
 1.在 JDK 8 及以后的版本中，static 变量保存在 Java 堆内存中
 （具体是跟随类的 Class 对象存储）；而在 JDK 6 及以前，
  它们保存在永久代（方法区）中。

 2.JDK 7 为了配合后续移除永久代的计划，已经将 字符串常量池
     (String Constant Pool) 和 静态变量 (Static Variables)
     从永久代移到了 Java 堆 中。剩下的类元数据依然在永久代。

**/
public class ChildGame {
    public static void main(String[] args) {
//        int counter = 0;
        Child child1 = new Child("白骨精");
        child1.join();
        child1.counter++;
        Child child2 = new Child("狐狸精");
        child2.join();
        child2.counter++;
        Child child3 = new Child("鸡精");
        child3.join();
        child3.counter++;
        // 类变量可以通过类名直接访问
        System.out.println("有" + Child.counter + "个小孩加入游戏");

        System.out.println("有" + child1.counter + "个小孩加入游戏");
        System.out.println("有" + child2.counter + "个小孩加入游戏");
        System.out.println("有" + child3.counter + "个小孩加入游戏");

    }
}

class Child {
    // 定义一个类变量/静态变量,
    // 这个变量最大的特点是 可以被Child类的所有对象实例所共享
    public static int counter = 0;
    private String name;

    Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(this.name + " 加入了游戏 ");
    }
}