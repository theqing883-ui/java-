package com.hspedu.final_;

//属性（变量）没有多态性，哪里定义哪里使用，永远不能被重写（Override），只能被隐藏（Hide）

/*
0.final 中文意思：最后的，最终的.final
    可以修饰类、属性、方法和局部变量。
    在某些情况下，程序员可能有以下需求，就会使用到 final:
1.如果要求A 类 不能被 继承 ，可以用final修饰A类
2.如果要求某 方法 不能被子类重写，则用final修饰该方法，但是可以被继承[此方法所在的类不是fina的]
    【public final void hi() {}】
3.如果不希望某个 属性 不能被修改，则可以用final修饰该属性,但是可以被隐藏也可以被继承
    【public final double TAX_RATE = 0.08;】
4.当不希望某个 局部变量 被修改时，可以使用final
    【 final double NUM = 0.09;】
5.
* */
public class Final01 {
    public static void main(String[] args) {
        //new E().TAX_RATE = 10;//无法进行修改
    }
}

/*
1.如果要求A类不能被 继承 ，可以用final修饰A类
2.如果要求某方法不能被子类重写，则用final修饰该方法，但是可以被继承
    【public final void hi() {}】
3.如果不希望某个属性不能被修改，则可以用final修饰该属性,但是可以重写可以被继承
    【public final double TAX_RATE = 0.08;】
4.当不希望某个局部变量被修改时，可以使用final
    【 final double NUM = 0.09;】
* */

//1.如果要求A类不能被 继承 ，可以用final修饰A类
final class A {
    //class A {
    final int x = 0;

}
//class B extends A { }

//2.如果要求某方法不能被子类重写，则用final修饰该方法，但是可以被继承
class C {
    public final void hi() {
    }
}

class D extends C {
    public void ee() {
        hi();
    }
    //不能重写
//    @Override
//    public void hi() {
//        System.out.println("重写C类的hi方法");
//    }
}

//3.如果不希望某个属性不能被修改，则可以用final修饰该属性,但是可以被继承
class E {
    public final double TAX_RATE = 10;
}

class F extends E {
    //    public final double TAX_RATE = 11;//可以重写
    public void ee() {
        System.out.println(TAX_RATE);
    }
}

//当不希望某个局部变量被修改时，可以使用final
class G {
    public void cry() {
        // 这时，NUM 也被称为局部常量
        final double NUM = 0.09;
        // NUM = 0.1;无法再修改
    }
}
