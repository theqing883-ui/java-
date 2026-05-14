package com.hspedu.poly_.dynamic;

/*
1.当调用方法的时候，该方法会和该对象的 内存地址 / 运行类型 绑定
2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用,编译类型中没有的属性（方法也是），在运行类型中有，同样不能访问，除非向下转型
 * */
public class DynamicBinding {
    public static void main(String[] args) {
        //main方法中
        // 编译类型A 运行类型B
        A a = new B();//向上转型
        System.out.println(a.sum());//30
        /* B类的sum()注释后
          此语句会先调用A中的sum()方法，但是在A类的sum()方法中调用了getI()方法，
          这时A和B类中都有getI()方法，这时我们需要看对象的 运行类型 是什么，从此类
          开始向上查找。
          这里a的运行类型是B，因此执行B类中的getI()方法
        * */

        System.out.println(a.sum1());//30
    }
}

class A {//父类
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {//子类
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getI() {
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
