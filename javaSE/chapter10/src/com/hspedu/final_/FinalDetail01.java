package com.hspedu.final_;

//属性（变量）没有多态性，哪里定义哪里使用，永远不能被重写（Override），只能被隐藏（Hide）
/*
1.final 修饰的属性又叫常量，一般用 XX_XX_XX 来命名
2.final 修饰的属性在定义时，必须赋初值，并且以后不能再修改，
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

3.final 类不能继承，但是可以实例化对象。
4.如果类不是 final 类，但是含有 final 方法，则该方法虽然不能重写，但是可以被继承。
5.一般来说，如果一个类已经是final类了，就没必要将方法用final修饰了
6.final 不能修饰构造器
7.final和static结合使用，往往 效率更高【只针对属性】
【说明：public static int num = 1; //调用这个静态变量时，会导致类加载】
【说明：public final static int num2 = 1; //用final 修饰后，调用这个静态变量时，就不会导致类加载】
8.包装类【Integer、Double、Float、Boolean】都是final类型的，
    String也是final类型的，不能被继承
    注意：String不是包装类
* */

public class FinalDetail01 {
    public static void main(String[] args) {
//        System.out.println(CC.num);
        System.out.println("-------------");
//        System.out.println(CC.num2);
        System.out.println("-------------");
//        CC.cry();
        System.out.println("-----------------");
        CC.cry1();
    }
}

class AA {
    /* final 修饰且非静态时的三种赋值方式
    1.定义时，如public final double TAX_RATE = 0.08
    2.在构造器中
    3.在代码块中
    * */
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    {
        this.TAX_RATE3 = 0.05;
    }

    public AA(int taxRate) {
        this.TAX_RATE2 = 0.05;
    }
}

class BB {
    /* final 修饰且静态时的两种种赋值方式
   1.定义时，如public final double TAX_RATE = 0.08
   2.在代码块中
   注：不能在构造器中【因为在类加载的时候静态属性就需要初始化，但是在类加载的时候，通常不会调用构造器
  【除非有个本类的静态对象要创建，饿汉式：private static Cat = new Cat("小米")，
   即使是这种情况，也不能在构造器中赋值，因为编译器在检查代码时，是非常“死板”的，不懂你的逻辑】
   * */
    public final static double TAX_RATE = 0.08;
    public final static double TAX_RATE2;

    static {
        TAX_RATE2 = 0.05;
    }
}

class CC {
    public final static double num = 1;
    public static double num2 = 2;

    static {
        System.out.println("CC静态代码块被调用");
    }

    public static void cry() {
        System.out.println("CC静态方法被调用");
    }

    /* 不管你是否加了 final，
    只要你调用了类的 static 方法，就会触发类的加载*/
    public final static void cry1() {
        System.out.println("CC静态方法被调用");
    }
}
