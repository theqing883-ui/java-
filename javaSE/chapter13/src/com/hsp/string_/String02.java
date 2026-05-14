package com.hsp.string_;

/*
# String类
● 两种创建String对象的区别
方式一：直接赋值 String s = "hsp";
方式二：调用构造器 String s2 = new String("hsp");

1. 方式一：先从常量池查看是否有“hsp”数据空间，如果有，直接指向；如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址
2. 方式二：先在堆中创建空间，里面维护了value属性，指向常量池的hsp空间。如果常量池没有“hsp”，重新创建，如果有，直接通过value指向。
最终指向的是堆中的空间地址
3. 画出两种方式的内存分布图
* */

/*
老韩小结: 底层是 StringBuilder sb = new StringBuilder(); sb.append(a);
sb.append(b); sb是在堆中，并且append是在原来字符串的基础上追加的.
重要规则, String c1 = "ab" + "cd";常量相加，看的是池。String c1 = a
+ b ;变量相加,是在堆中
* */

public class String02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("Hello");
        String s3 = "Hello";



        /*
        1、先创建一个StringBuilder sb = StringBuilder;
        2、执行 sb.append("abc");
        3、sb.append("Hello");
        4、String s4 = sb.toString(); 使用了new
        5、最后s4 指向堆中的对象(String) value[] -> 池中的"abcHello"
        * */

        String s4 = s1 + s3;
        String s5 = "abc" + "Hello";
        String s6 = "abcHello";
        System.out.println(s4 == s5);
        System.out.println(s5 == s6);
    }
}
