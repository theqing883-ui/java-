package com.hspedu.poly_.Object_;
import java.sql.Date;
public class EqualsExercise02 {
    public static void main(String[] args) {
        //代码如下 EqualsExercise03.java 2min
        int it = 65;
        float f1 = 65.0f;
        System.out.println("65和65.0f是否相等？" + (it == f1));

        char ch1 = 'A';//65
        char ch2 = 12;//赋ASCII值为12的字符
        System.out.println("65和'A'是否相等？" + (it == ch1));
        System.out.println("12和ch2是否相等？" + (12 == ch2));
        System.out.println("ch2=" + ch2);
        System.out.println("ch1=" + ch1);

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("str1和str2是否相等？" + (str1 == str2));

        System.out.println("str1是否equals str2？" + (str1.equals(str2)));
//        System.out.println("hello" == new java.sql.Date());//"hello"和new java.sql.Date()类型不一样，编译报错
    }
}
