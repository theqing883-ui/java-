package com.hsp.stringbuffer_;

public class StringAndStringBuffer {
    public static void main(String[] args) {
        // String转StringBuffer
        //1、方式1利用构造器
        String a = "Hello World";
        StringBuffer stringBuffer = new StringBuffer(a);//对a并没有改变
        //方式2 利用append()方法
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer append = stringBuffer1.append(a);

        //StringBuffer转String
        StringBuffer stringBuffer2 = new StringBuffer("Hello World");
        //方式1 利用StringBuffer的toString()
        String a1 = stringBuffer2.toString();
        //方式2 利用构造器
        String a2 = new String(stringBuffer2);


    }
}
