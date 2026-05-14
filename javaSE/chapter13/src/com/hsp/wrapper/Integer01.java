package com.hsp.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        /*
         * 1.演示int -- Integer 的装箱和拆箱
         * 2.JDK5前手动装箱
         * 3.JDK及其以后自动装箱
         * */

        //手动装箱 int -> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱 Integer -> int
        int i = integer.intValue();//对象.方法

        //JDK5后
        // 自动装箱
        int n2 = 200;
        Integer integer2 = n2;//底层任然是Integer.valueOf(n2);

        //自动拆箱
        int i2 = integer2;//底层仍然使用的是integer.intValue();

    }
}
