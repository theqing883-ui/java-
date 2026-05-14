package com.hspedu.poly_.detail;

public class PolyDetail2 {
    public static void main(String[] args) {
//  属性没有重写之说！属性的值看编译类型
    Base base = new Sub();
    System.out.println(base.count);
    }
}
class Base {//父类
    int count = 10;
}
class Sub extends Base {//子类
    int count = 20;
    int a = 0;
}