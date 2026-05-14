package com.hspedu.abstract_;

/*
* 这是一张关于Java抽象类的教学内容图片，核心信息及解读如下：
1. **抽象类的定义**
   - 当父类的部分方法无法确定具体实现时，可用`abstract`修饰该方法（即抽象方法），
   * 同时用`abstract`修饰类，该类即为抽象类。
2. **代码示例说明**
   - 以`Animal`类为例，将其定义为抽象类，并包含抽象方法`cry()`
   * （表示动物的叫声，不同动物叫声不同，父类无法确定具体实现），
   * 同时定义了属性`name`和`age`。
   - 子类（如`Cat`）需要继承该抽象类，并实现`cry()`方法。

**抽象类的核心特点**：
- abstract只能修饰类或者方法
- 包含抽象方法的类必须是抽象类；
- 抽象类不能直接实例化，需通过子类继承并实现所有抽象方法后使用；
- 子类继承抽象类时，必须重写所有抽象方法（除非子类也是抽象类）。

* */

/*
* **抽象类的核心特点**：
- abstract只能修饰类或者方法；
- 抽象类可以没有抽象方法，但抽象方法所在的类必须是抽象类；
- 抽象类不能直接实例化，需通过子类继承并实现所有抽象方法后使用；
- 子类继承抽象类时，必须重写所有抽象方法（除非子类也是抽象类）；
- 抽象类可以有任意成员【抽象类本质还是类】，
*  比如：非抽象方法、构造器、静态属性等等
- 抽象方法不能有主体，即不能实现
- 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法[包括父类从超类继承的抽象方法]，
*   除非它自己也声明为abstract类。[举例 A类 B类 C类]
— 抽象方法不能用private、final、static来修饰，因为这些关键词都和方法的重写相违背。
* 说明：1).private方法不能被继承，final方法不能被重写，static 方法和编译类型绑定，只能被隐藏不能被重写
- 抽象类不能被private,final修饰
* */

public class AbstractDetail01 {
    public static void main(String[] args) {
        // new A();//抽象类不能实例化
    }
}

abstract class A {
    public final static int x = 1;

    public A() {
    }

    private void print() {
    }

    //抽象类可以没有抽象方法，但抽象方法所在的类必须是抽象类
    public abstract void method();
}

abstract class B extends A {
    public abstract void method2();
}

class C extends B {
    public void method() {
    }

    public void method2() {
    }
}

// 抽象方法不能用private、final、static来修饰，
// 因为这些关键词都和方法的重写相违背。
abstract class D {
//    public static abstract void y3();
//
//    private abstract void y1();
//
//    final abstract void y2();
}




