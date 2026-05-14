package com.hspedu.codeblock;
/*
1. 基本介绍
    代码块又称初始化块，是类的成员之一，类似方法：
    将逻辑语句封装在{}中；
    与方法的区别：无方法名、无返回值、无参数，无需通过对象 / 类显式调用，
    会在类加载时或创建对象时隐式调用。
2. 修饰符可选，若写只能是static；
3. 代码块分两类：
    用static修饰 → 静态代码块；
    无static修饰 → 普通代码块 / 非静态代码块；
4. 代码块内可写任意逻辑语句（输入、输出、方法调用、循环、判断等）；
5. 代码块末尾的;可写可不写。
* */

/*
1. 核心作用相当于另一种形式的构造器（普通代码块是构造器的补充机制），可用于执行初始化操作。
2. 典型场景若多个构造器中存在重复语句，可将重复代码抽取到初始化块中，提升代码的复用性。
* */


/*
 1. 3个构造器-》重载
 2. 3个构造器有相同语句，冗余，可以将相同语句放入一个代码块中
 3. 不管我们调用哪个构造器创建对象，都会先调用代码块
 4. 代码块调用的顺序优先于构造器
* */
public class CodeBlock01 {
    public static void main(String[] args) {
        Movie m1 = new Movie("胖娃娃");
        System.out.println("--------------------");
        Movie m2 = new Movie(200,"黎明");
        System.out.println("--------------------");
        Movie m3 = new Movie("我不是药神",100,"忘记了");

    }
}

class Movie {
    private String name;
    private String director;
    private double price;

//     1. 3个构造器-》重载
//     2. 3个构造器有相同语句，冗余，可以将相同语句放入一个代码块中
//     3. 不管我们调用哪个构造器创建对象，都会先调用代码块
//     4. 代码块调用的顺序优先于构造器
    {//代码块
        System.out.println("电影屏幕打开");
        System.out.println("广告开始");
        System.out.println("电影开始了");
    };

    public Movie(String name) {
        this.name = name;
    }

    public Movie(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
