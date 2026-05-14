package com.hsp.stringbuilder_;

public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {
        /*
        # StringBuilder类

● String、StringBuffer和StringBuilder的比较
1) StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，而
    且方法也一样
2) String：不可变字符序列, 效率低,但是复用率高。
3) StringBuffer：可变字符序列, 效率较高(增删)、线程安全, 看源码
4) StringBuilder：可变字符序列, 效率最高、线程不安全

5) String使用注意说明：
 string s="a";//创建了一个字符串
 s += "b";//实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个字符串s+"b"
    （也就是"ab"）。对字符串进行大量这样的修改字符串内容的操作，
    会导致大量副本字符串对象留在内存中，降低效率。如果这样的操作放到循环中，
    会极大影响程序的性能 => 结论：如果我们对String做大量修改,
     不要使用String
        * */
/*
# StringBuilder类
● String、StringBuffer 和StringBuilder的选择
使用的原则 结论:
1. 如果字符串存在大量的修改操作, 一般使用 StringBuffer 或StringBuilder
2. 如果字符串存在大量的修改操作, 并在单线程的情况, 使用 StringBuilder
3. 如果字符串存在大量的修改操作, 并在多线程的情况, 使用 StringBuffer
4. 如果我们字符串很少修改, 被多个对象引用, 使用String,比如配置信息等

StringBuilder 的方法使用和 StringBuffer 一样, 不再说.
* */
    }
}
