package com.hsp.string_;
/*
String类的理解和创建对象

String01.java
1) String 对象用于保存字符串，也就是一组字符序列
2) 字符串常量对象是用双引号括起的字符序列。例如："你好"、"12.97"、"boy"等
3) 字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节。
4) String类较常用构造器(其它看手册):
    String s1 = new String(); //
    String s2 = new String(String original);
    String s3 = new String(char[] a);
    String s4 = new String(char[] a,int startIndex,int count)
5) String 实现了Serializable【可以串行化，即可以网络传输】
    和 Comparable接口【可以比较大小】
6) String 是一个final类，即不可以被继承
7) String 有一个 private final char value[];属性，用于存放字符串内容
8) 注意： value 是final类型的，只能赋值一次，不可以修改
9) 还要注意：value 是数组名，真正存放的是指向数组的地址，所以这里的不可修改是指
  数组的地址不可修改，即value不能再指向其他对象，而数组的内容可以修改。

* */


public class String01 {
    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1.intern());
        /*
        intern()方法的作用是：返回字符串在常量池中的规范表示
        具体规则：
        如果常量池中已存在等于此String对象的字符串（用equals()比较），
            则返回常量池中该字符串的引用
        否则，将此String对象包含的字符串添加到常量池中，并返回此引用
        老韩解读: (1).intern()方法最终返回的是常量池的地址（对象）
        * */
        /*
        核心原因：
        System.out.println()在打印对象时，会调用该对象的toString()方法。
        对于String对象，toString()方法返回字符串本身的内容（而不是地址）。
        * */
//        String.valueOf();
        System.out.println(new String("wasda").intern());
    }
}
