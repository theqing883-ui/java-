package com.hspedu.codeblock;

/*
1.我们看一下创建一个子类对象时 (继承关系), 他们的静态代码块、
    静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下:
    ① 父类的 静态代码块和静态属性 (优先级一样，按定义顺序执行)
    ② 子类的 静态代码块和静态属性 (优先级一样，按定义顺序执行)
    （1,2属于类加载过程）
    ③ 父类的 普通代码块和普通属性 初始化 (优先级一样，按定义顺序执行)
    ④ 父类的构造方法
    ⑤ 子类的 普通代码块和普通属性 初始化 (优先级一样，按定义顺序执行)
    ⑥ 子类的构造方法
    （3,4,5,6属于创建对象过程）
AAAAA extends BBBBB 类 演示 [ 10Min ] 55 CodeBlockDetail04.java

2.静态代码块只能直接调用静态成员 (静态属性和静态方法), 普通代码块可以调用任意成员。
* */

/*  假设我们执行 new Son()，且是第一次使用这两个类，JVM 的具体动作如下：
1.第一阶段：类加载（Class Loading）
    这只发生一次，不管你 new 多少个对象，静态部分只执行一次。
    1) 加载父类（Father）：JVM 发现 Son 继承自 Father，必须先加载 Father。
       执行 Father 的 静态变量 初始化和 静态代码块（按代码书写顺序执行）。
    2) 加载子类（Son）：
    执行 Son 的 静态变量 初始化和 静态代码块（按代码书写顺序执行）。
2.第二阶段：对象创建（Object Creation）
    每次 new 一个新对象，这部分都会重复执行。
    1) 父类初始化（Father Instance）：
    执行 Father 的 普通成员变量 初始化(默认初始化、显示初始化) 和 普通代码块（按代码书写顺序执行）。
    注意：普通代码块和普通变量优先级相同，谁写在前面谁先执行。
    2) 父类构造器（Father Constructor）： 执行 Father 的构造方法。
    3) 子类初始化（Son Instance）：执行 Son 的 普通成员变量 初始化和 普通代码块。
    4) 子类构造器（Son Constructor）：执行 Son 的构造方法。
* */


public class CodeBlockDetail04 {
    public static void main(String[] args) {
        //老师说明
        // (1) 进行类的加载
        // 1.1 先加载 父类 A021.2 再加载 子类 B02
        // (2) 创建对象
        // 2.1 从子类的构造器开始
        new B02();//对象
        /*输出： getVal01
                A02 的一个静态代码块..
                getVal03
                B02 的一个静态代码块..
                getVal02
                A02 的第一个普通代码块..
                A02 的构造器
                getVal04
                B02 的第一个普通代码块..
                B02的构造器*/
        System.out.println("------------------------------");
        new C02();
    }
}

class A02 { //父类
    private static int n1 = getVal01();

    static {
        System.out.println("A02 的一个静态代码块..");//(2)
    }

    public int n3 = getVal02();//普通属性的初始化

    {
        System.out.println("A02 的第一个普通代码块..");//(5)
    }

    public A02() {//构造器
        //隐藏
        //super()
        //普通代码和普通属性的初始化......
        System.out.println("A02 的构造器");//(7)
    }

    public static int getVal01() {
        System.out.println("getVal01");//(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");//(6)
        return 10;
    }
}

class C02 {
    private static int n2 = 200;

    static {
        //静态代码块，只能调用静态成员
        //System.out.println(n1);错误
        System.out.println(n2);//ok
        //m1();//错误
        m2();
    }

    private int n1 = 100;

    {
        //普通代码块，可以使用任意成员
        System.out.println(n1);
        System.out.println(n2);//ok
        m1();
        m2();
    }

    private static void m2() {
    }

    private void m1() {
    }
}

class B02 extends A02 { //
    private static int n3 = getVal03();

    static {
        System.out.println("B02 的一个静态代码块..");//(4)
    }

    public int n5 = getVal04();

    {
        System.out.println("B02 的第一个普通代码块..");//(9)
    }

    public static int getVal03() {
        System.out.println("getVal03");//(3)
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");//(8)
        return 10;
    }

    //一定要慢慢地去品..
    public B02() {//构造器
        //隐藏了
        //super()
        //普通代码块和普通属性的初始化...
        System.out.println("B02的构造器");//(10)
        //TODO Auto-generated constructor stub
    }
}