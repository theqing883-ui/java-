package com.hspedu.extend_.improve_;

/*
* 继承可以解决代码复用，让我们的编程更加靠近人类思维。当多个类存在相同的属性（变量）
* 和方法时，可以从这些类中抽象出父类，在父类中定义这些相同的属性和方法。
* 所有的子类不需要重新定义这些属性和方法，只需要通过 extends 来声明继承父类即可。
*
* class 子类 extends 父类 {
    1) 子类就会自动拥有父类定义的属性和方法
    2) 父类又叫超类，基类。
    3) 子类又叫派生类。
    4) 调用方式和子类调用的自己方法和属性一样
}
* */


public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小米~";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(90);
        pupil.print();

        System.out.println("================ ");
        Graduate graduate = new Graduate();
        graduate.name = "大米~";
        graduate.age = 25;
        graduate.testing();
        graduate.setScore(99);
        graduate.print();
    }
}
