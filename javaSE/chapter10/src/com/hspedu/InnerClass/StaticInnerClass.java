package com.hspedu.InnerClass;

/*
内部类
●静态内部类的使用 StaticInnerClass01.java
说明：静态内部类是定义在外部类的成员位置，并且有static修饰
1. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
2. 可以添加任意访问修饰符(public、protected、默认、private),因为它的地位就是一个成员。
3. 作用域：同其他的成员，为整个类体
4. 静态内部类----访问----->外部类(比如：静态属性)
    [访问方式：直接访问所有静态成员]
5. 外部类----访问----->静态内部类 访问方式：创建对象，再访问
6. 外部其他类，使用静态内部类(两种方式)
    方式1：外部类名.内部类名();
    方式2：外部内中写一个方法，返回一个内部类
7. 当外部类和静态内部类的成员重名时，访问时采用就近原则，如果要访问外部类的该成员
    则可以使用(外部类名.成员名)去访问。
* */
public class StaticInnerClass {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.show();
        //外部其他类，使用静态内部类
        //方式1：外部类名.内部类名();
        System.out.println("=========================");
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
//        Outer10.Inner10.say();
        System.out.println("=========================");
        //方式2：外部内中写一个方法，返回一个内部类
        Outer10.Inner10 inner11 = outer10.getInner10();
        inner11.say();
        System.out.println("=========================");
        Outer10.Inner10 inner12 = Outer10.getInner10_();
        inner12.say();
    }
}

class Outer10 {
    private static String name = "历史";
    private int n1 = 10;

    public static void cry() {
    }

    public static Inner10 getInner10_() {
        return new Inner10();
    }

    public void show() {
        //外部类访问静态内部类：先创建对象，再访问
        new Inner10().say();
    }

    public Inner10 getInner10() {
        return new Inner10();
    }

    //1.放在外部类的成员位置，用static修饰
    //2.使用static 修饰
    //3.可以添加任意地访问修饰符
    //4.作用域：同其他的成员一样，为整个类体
    static class Inner10 {
        private static String name = "112";

        public void say() {
            //可以访问外部类的所有静态成员
            System.out.println(name);
            //静态内部类访问外部重名的静态成员
            System.out.println(Outer10.name);
            cry();
            //无法访问外部类的非静态成员
            //System.out.println(n1);
        }
    }
}
