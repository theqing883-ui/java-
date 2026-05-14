package com.hspedu.InnerClass;
/*
1.可以创建对象但不创建对象名(匿名对象)，直接调用方法
2.可以直接访问外部类的所有成员，包含私有的 [案例演示]
3.不能添加访问修饰符，因为它的地位就是一个局部变量。[过]
4.作用域：仅仅在定义它的方法或代码块中。[过]
5.匿名内部类 ---- 访问 -----> 外部类成员 [访问方式：直接访问]
6.外部其他类 ---- 不能访问 -----→匿名内部类（因为 匿名内部类地位是一个局部变量）
7.如果外部类和匿名内部类的成员重名时，内部类访问的话，
    默认遵循就近原则，如果想访问外部类的成员，则可以使用（外部类名.this. 成员）去访问

* */
public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符，因为他的地位就是一个局部变量
        //作用域：仅仅能在定义它的方法和代码块中使用一次
        //匿名内部类可以直接访问外部类成员
        //外部其他类不可以访问内部类（当然包括属性和方法）
         /*如果外部类和局部内部类的成员重名时，
              默认遵循就近原则，如果想访问外部类的成员，
              则可以使用（外部类名.this. 成员）去访
              说明:Outer02.this 本质是一个外部类的对象，
              即哪个对象调用了m2,Outer02.this 就是哪个对象。*/
        Person p = new Person() {
            private int n1 = 100;

            @Override
            public void hi() {
                //可以访问外部类的所有成员（属性 方法），包括私有的
                System.out.println(Outer05.this.n1);
                /*如果外部类和局部内部类的成员重名时，
                 默认遵循就近原则，如果想访问外部类的成员，
                 则可以使用（外部类名.this. 成员）去访
                说明:Outer02.this 本质是一个外部类的对象，
                即哪个对象调用了m2,Outer02.this 就是哪个对象。*/
                System.out.println("匿名内部类重写 hi 方法");
            }
        };
        p.hi();//动态绑定，运行类型为Outer$1

      /*  //可以创建对象但不创建对象名，直接调用方法
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写hi方法， 哈哈哈哈-----");
            }

            @Override
            public void ok(String str) {
                System.out.println("匿名内部类重写了 ok 方法 " + str);
            }
        }.ok("cc");//动态绑定，运行类型为Outer$1*/
    }
}

class Person {
    public void hi() {
        System.out.println(" Person  hi");
    }

    public void ok(String str) {
        System.out.println(" Person  ok " + str);
    }
}
