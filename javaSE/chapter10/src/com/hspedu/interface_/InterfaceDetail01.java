package com.hspedu.interface_;

/*1.接口（interface）和抽象类(abstract class)有点类似，可以说接口是一种特殊的抽象类
2.实现（implements）和继承有点类似，可以说实现就是一种特殊的继承
3.类实现了接口后，就继承了接口的属性和方法（同样受到访问修饰符，static,final的限制）*/


/*
1. 接口不能实例化
2.接口中所有的方法都是public的，接口中的抽象方法可以不用abstract修饰
3.一个普通类实现接口就必须实现接口中的所有抽象方法//alt+enter 快捷键
4.抽象类实现接口，可以不实现接口的抽象方法
5.一个类可以实现多个接口
6.接口中的属性都是public static final 的,且可以省略关键词
7.接口中访问属性格式：接口名.属性
8.接口不能继承类，但是可以继承多个别的接口
9.接口的修饰符只能是public 和默认
* */

interface IA {
    //6.接口中的属性都是public static final 的
    int n1 = setN1();

    //静态方法只能访问静态属性
    public static int setN1() {
        System.out.println("IA setN1 b被调用");
        return 1;
    }

    void say();//可以省略public 和 abstract

    default void say2() {
        System.out.println("IA say2");

    }
}

interface IB {
}

//8.接口不能继承类，但是可以继承多个别的接口
interface IC extends IA, IB {
}

/*1.接口（interface）和抽象类(abstract class)有点类似，可以说接口是一种特殊的抽象类
2.实现（implements）和继承有点类似，可以说实现就是一种特殊的继承
类实现了接口后，就继承了接口的属性和方法（同样受到访问修饰符，static,final的限制）*/
/*
1. 接口不能实例化
2.接口中所有的方法都是public的，接口中的抽象方法可以不用abstract修饰
3.一个普通类实现接口就必须实现接口中的所有抽象方法//alt+enter 快捷键
4.抽象类实现接口，可以不实现接口的抽象方法
5.一个类可以实现多个接口
6.接口中的属性都是public static final 的,且可以省略关键词
7.接口中访问属性格式：接口名.属性
8.接口不能继承类，但是可以继承多个别的接口
9.接口的修饰符只能是public 和默认
* */
public class InterfaceDetail01 {
    public static void main(String[] args) {

    }
}

class AA implements IA {

    @Override
    public void say() {

    }
}

class Pig implements IA, IB {
    @Override
    public void say() {

    }
}