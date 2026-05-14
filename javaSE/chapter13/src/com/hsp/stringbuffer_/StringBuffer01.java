package com.hsp.stringbuffer_;

/*
# StringBuffer类
● String VS StringBuffer
1) String保存的是字符串常量，里面的值不能更改，每次String类的更新实际上就是更改地址，效率较低 //private final char value[];
2) StringBuffer保存的是字符串变量，里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，不用每次更新地址，效率较高
//char[] value; //这个放在堆
* */

public class StringBuffer01 {
    public static void main(String[] args) {
        /*
        * 1、直接父类是 AbstractStringBuilder
        * 2、实现的接口：Serializable
        * 3、在父类中 AbstractStringBuilder 有属性 char[] value 不是final类型
        *  该 value 数组存放字符串内容，因此存放在堆中，不在和String一样存放在常量池
        * 4、StringBuilder是一个final类，不能被继承
        * 5、因为StringBuilder 的字符内容char[] value，所有在变化【删除/增加】
        * 不用每次都重新创建新对象[mor超过16个要重新创建]，所以效率高于String
        * */
        StringBuffer sb = new StringBuffer();
    }
}
