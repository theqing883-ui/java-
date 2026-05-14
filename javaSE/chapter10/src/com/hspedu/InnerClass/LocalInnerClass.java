package com.hspedu.InnerClass;

/*
局部内部类的使用 LocalInnerClass.java
说明：局部内部类是定义在外部类的局部位置，比如方法中，并且有类名。

1.可以直接访问外部类的所有成员，包含私有的
2.不能添加访问修饰符，因为它的地位就是一个局部变量。
    局部变量是不能使用修饰符的。但是可以使用 final 修饰，
    因为局部变量也可以使用 final
3.作用域：仅仅在定义它的方法或代码块中。
4.局部内部类 ---- 访问 -----> 外部类的成员【访问方式：直接访问】
5.外部类 ---- 访问 -----> 局部内部类的成员
6.访问方式：创建对象，再访问 (注意：必须在作用域内)
7.外部其他类不能访问局部内部类(因为局部内部类是一个局部变量)
8.如果外部类和局部内部类的成员重名时，
     默认遵循就近原则，如果想访问外部类的成员，
     则可以使用（外部类名.this. 成员）去访
    说明:Outer02.this 本质是一个外部类的对象，
    即哪个对象调用了m2,Outer02.this 就是哪个对象。
* */
public class LocalInnerClass {//外部其他类

    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println(outer02);


        //7.外部其他类不能访问局部内部类(因为局部内部类是一个局部变量)
        // new Inner02();
    }
}

class Outer02 {//外部类
    private int x = 100;

    private void foo() {
        System.out.println("foo");
    }

    public void m1() {//ff
        //1.局部内部类时定义在外部类的局部位置(代码块，方法内等)，通常在方法内
        //3.不能用访问修饰符,修饰局部访问修饰符，但是可以使用final修饰
        //4.作用域：不仅仅在定义他的方法或者代码块中

        final class Inner02 {//内部类(本质仍然是一个类)
            private int x = 800;

            //2.可以之间访问外部类的成员，包括私有的
            public void m2() {
                //5.局部内部类可以 直接访问 外部类的成员
                /*8.如果外部类和局部内部类的成员重名时，
                 默认遵循就近原则，如果想访问外部类的成员，
                 则可以使用（外部类名.this. 成员）去访
                说明:Outer02.this 本质是一个外部类的对象，
                即哪个对象调用了m2,Outer02.this 就是哪个对象。*/
                System.out.println("内部类的x" + x);
                System.out.println("外部类的x" + Outer02.this.x);
                System.out.println(Outer02.this);
                /*在Java中，System.out.println(对象名); 输出的是 对象的 toString() 方法的返回值，
                 * 如果你没有在类中重写 toString() 方法就会输出hashCode值*/
                foo();
            }
        }
        //6.外部类在方法中，可以创建Inner02对象，然后调用方法即可
        System.out.println("==================");
        Inner02 inner02 = new Inner02();
        inner02.m2();
//        class Inner03 extends Inner02 {
//        }
    }


}
