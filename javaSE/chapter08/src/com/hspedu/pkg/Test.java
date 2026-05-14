package com.hspedu.pkg;

import com.hspedu.modifier.A;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        A a = new A();
//      在不同包下只能访问public修饰的属性和方法
//      不能访问protected private 默认 修饰的属性和方法
        System.out.println("n1 = " + a.n1);
    }
}
