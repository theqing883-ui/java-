package com.hsp.wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类 -> String
        Integer i = 100;
        int j = 100;
        //方式1
        String s = i + "";//i本身没变化
        String s2 = j + "";
        //方式2
        String s1 = i.toString();//对象.toString()
        //方式3
        String s3 = String.valueOf(i);

        //String -> 包装类
        String s4 = "1212";
        //方式1
        Integer i1 = Integer.parseInt(s1);
        //返回的其实是int类型，但是会自动装箱
        int i2 = Integer.parseInt(s1);
        //方式2
        Integer i3 = new Integer(s4);//利用Integer的构造器
        //方式3
        Integer i4 = Integer.valueOf(s4);//利用valueOf方法

        System.out.println("OK~~");


    }
}
