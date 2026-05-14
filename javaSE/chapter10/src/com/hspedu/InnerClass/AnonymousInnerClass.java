package com.hspedu.InnerClass;

/*
 基于接口的匿名内部类
        1.想使用接口IA，并创建对象
        2.传统方法，是写一个类，实现该接口，并创建对象
        3.Tiger 类只使用一次，后面不在使用，太浪费了，这时可以使用匿名类
        4.tiger的编译类型？接口IA
        5.tiger的运行类型？匿名内部类XXX->外部类$1（Outer04$1）
        6.匿名内部类：外部类$1，只能使用一次，使用一次就没了
        7.JDK底层在创建内部类 外部类$1 后，立即就创建了一个 外部类$1 的实例对象
         并把地址返回个对象名
        8.匿名内部类创建的对象当然可以多次使用
* */

/*
基于类的匿名内部类
     * 1.father 的编译类型 Father
     * 2.father 运行类型 匿名内部类XXX->外部类$1（Outer04$2 ）
     * 3.底层会创建匿名内部类
     * 4.同时也创建了匿名内部类的对象，
     *      class Outer04$1 extends Father{
     *          @Override
                public void test() {
                System.out.println("重写了test方法");
                }
     *      }
     * */
// 5.这里的参数列表"jake"，会直接传给构造器

interface IA {
    void cry();
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {

    private int n1 = 10;

    public void method() {
        /* ===============基于 接口 的匿名内部类=================*/
//        1.想使用接口IA，并创建对象
//        2.传统方法，是写一个类，实现该接口，并创建对象
//        3.Tiger 类只使用一次，后面不在使用，太浪费了，这时可以使用匿名类
//        4.tiger的编译类型？接口IA
//        5.tiger的运行类型？匿名内部类XXX->外部类$1（Outer04$1 1:表示第一个匿名内部类）
//        6.匿名内部类：外部类$1，只能使用一次，使用一次就没了
//        7.JDK底层在创建内部类 外部类$1 后，立即就创建了一个 外部类$1 的实例对象
//         并把地址返回个对象名
//        8.匿名内部类使用一次就不能使用了，创建的对象当然可以多次使用
        /*
            底层：
            class 外部类$1 implements IA {
            @Override
             public void cry() {
                System.out.println("老虎嗷嗷叫~~~~~");
            }
            IA tiger = new 外部类$1()
        * */
        IA tiger = new IA() {//接口类型的匿名内部类
            public void cry() {//重写了接口的抽象方法
                System.out.println("老虎嗷嗷叫~~~~~");
            }
        };//注意这里有个分号,因为他本质就是，一条创建对象的语句
        tiger.cry();
        tiger.cry();
        System.out.println("tiger 的运行类型 " + tiger.getClass());
        //tiger.getClass() 返回对象tiger的运行类型




        /*==========基于类的匿名内部类===================*/
        System.out.println("===========================");

        /*
         * 1.father 的编译类型 Father
         * 2.father 运行类型 匿名内部类XXX->外部类$1（Outer04$2 ）
         * 3.底层会创建匿名内部类
         * 4.同时也创建了匿名内部类的对象，
         *      class Outer04$1 extends Father{
         *          @Override
                    public void test() {
                    System.out.println("重写了test方法");
                    }
         *      }
         * */
        // 5.这里的参数列表"jake"，会直接传给构造器
        Father father = new Father("jake") {
            @Override
            public void test() {
                System.out.println("重写了test方法");
            }
        };
        father.test();
        System.out.println("father 的运行类型 " + father.getClass());
        //father.getClass() 返回对象father的运行类型

        /*==========基于抽象类的匿名内部类===================*/
        System.out.println("===========================");
        Animal animal =  new Animal(){
            @Override
            public void eat() {
                System.out.println("小狗狗吃骨头");
            }
        };
        System.out.println("animal 的运行类型 " + animal.getClass());
        animal.eat();
    }

}


class Father {
    public Father(String name) {
        System.out.println( " 接收到的name + " + name);
    }

    public void test() {

    }
}

abstract class Animal {
    public abstract void eat();
}
