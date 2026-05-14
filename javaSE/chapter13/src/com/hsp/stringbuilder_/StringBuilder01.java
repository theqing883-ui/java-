package com.hsp.stringbuilder_;

/*
# StringBuilder类

● 基本介绍
StringBuilder01.java
1)一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API，
    但不保证同步(StringBuilder 不是线程安全)。
    该类被设计用作 StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候。
    如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快[后面测]。
2)在 StringBuilder 上的主要操作是 append 和 insert 方法，
    可重载这些方法以接受任意类型的数据。
* */

public class StringBuilder01 {
    public static void main(String[] args) {
        /*
        1、同样继承了AbstractStringBuilder
        2、实现了Serializable，可以串行化
        3、StringBuilder 是final类 不可被继承
        4、StringBuilder 对象的字符 同样存放在父类AbstractStringBuilder的char[] value
        5、StringBuilder的方法没有互斥的处理，即没有 synchronized 关键字，
            因此在单线程情况下使用 StringBuilder
        * */

        StringBuilder stringBuffer = new StringBuilder();
    }
}
