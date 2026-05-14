package com.hsp.stringbuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {
        //构造器的使用
        //1、创建一个大小为16 的char[]，用于存放字符内容
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        //2、通过构造器指定char[] 大小
        StringBuffer sb1 = new StringBuffer(100);

        //3、通过给一个 String 创建StringBuffer
        StringBuffer sb2 = new StringBuffer("hello");//char[] 长度"hello".length + 16
    }
}
