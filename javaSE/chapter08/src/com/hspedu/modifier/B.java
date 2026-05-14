package com.hspedu.modifier;

import java.sql.SQLOutput;

public class B {
//  同一个包不同类里面可以访问：public protected 默认
//    不能访问private
    public void say(){
        A a = new A();
        System.out.println("B类被调用");
//    不能访问 n4 n4 为private修饰
        System.out.println("n1 = " + a.n1 + " n2 = " + a.n2
                + " n3 = " + a.n3);
    }
}
