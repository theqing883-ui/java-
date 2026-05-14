package com.hspedu.InnerClass;

/*
1.说明：成员内部类是定义在外部类的成员位置，并且没有 static 修饰。
2.可以直接访问外部类的所有成员，包含私有的
3.可以添加任意访问修饰符 (public、protected、默认、private),
    因为它的地位就是一个成员。
4.作用域 MemberInnerClass02.java和外部类的其他成员一样，为整个类体
5.成员内部类 ---- 访问 -----> 外部类（比如：属性）,访问方式：直接访问（说明）
6.外部类 ---- 访问 -----> 成员内部类（说明）,访问方式：创建对象，再访问
7.外部其他类 ---- 访问 -----> 成员内部类(两种方法)
    1) 方式一：外部类名.内部类名 内部类对象名 = 外部类对象.new 内部类名
    Outer08.Inner08 inner08 = outer08.new Inner08();
    Outer08.Inner08 本质是表示内部类（为 类 这个引用数据类型）
    2) 方式二：外部内中写一个方法，返回一个内部类
8. 如果外部类和内部类成员重名的话，默认遵循就近原则，
    如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
9.在 Java 16 及以后： 可以。非静态内部类完全支持静态成员（变量、方法）。
    在 Java 16 以前（如 Java 8）： 不可以，
    除非是常量（即 static final 且由编译期常量赋值的变量）
* */

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();
        System.out.println("=================");

        //外部其他类，使用成员内部类的两种方式(遵守访问修饰符的规则)
        //方式1：因为Inner08 是在外部类的成员地位，因此采用outer08.
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();
        System.out.println("=================");

        //方式2：外部内中写一个方法，返回一个内部类
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();

        //方式3

    }

}

class Outer08 {
    public String name = "ccc";
    private int n1 = 10;

    //方法
    public void t1() {
        //外部类使用成员内部类,创建对象，再访问
        new Inner08().say();
    }

    public Inner08 getInner08Instance() {
        return new Inner08();
    }

    //注意：成员内部类定义在外部类的成员位置上
    //可以任意添加访问修饰符，因为它的地位就是一个成员
    public class Inner08 {
        public void say() {
            //可以访问外部内的所有属性
            System.out.println("Outer01 : " + n1 + "Outer01 : " + name);
        }
    }
}
