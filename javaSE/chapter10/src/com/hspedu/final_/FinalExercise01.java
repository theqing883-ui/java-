package com.hspedu.final_;

/*2.final 修饰的属性在定义时，必须赋初值，并且以后不能再修改，
    1)final 修饰且非静态时的三种赋值方式
        1.定义时，如public final double TAX_RATE = 0.08
        2.在构造器中
        3.在普通代码块中
    2)final 修饰且静态时的两种种赋值方式
       1.定义时，如public final double TAX_RATE = 0.08
       2.在静态代码块中
       注：不能在构造器中【因为在类加载的时候静态属性就需要初始化，但是在类加载的时候，通常不会调用构造器
      【除非有个本类的静态对象要创建，饿汉式：private static Cat = new Cat("小米")，
       即使是这种情况，也不能在构造器中赋值，因为编译器在检查代码时，是非常“死板”的，不懂你的逻辑】
*/

public class FinalExercise01 {
    public static void main(String[] args) {
        System.out.println(Circle1.pem(5));
        System.out.println(Circle2.pem(5));
        System.out.println((new Circle3(3.14, 5)).pem());
    }
}

class Circle1 {
    private final static double PI = 3.14;

    public final static double pem(double radius) {
        return PI * radius * radius;
    }
}

class Circle2 {
    private final static double PI;

    static {
        PI = 3.14;
    }

    public final static double pem(double radius) {
        return PI * radius * radius;
    }
}

class Circle3 {
    private final double PI;
    public double radius;

    public Circle3(double PI, double radius) {
        this.PI = PI;
        this.radius = radius;
    }

    public final double pem() {
        return PI * radius * radius;
    }
}
