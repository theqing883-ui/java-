package com.hspedu.static_;
/*
    静态方法 不能 直接访问 非静态成员。
    非静态方法 可以 随意访问 静态成员。
    静态方法不能使用this
* */

import java.util.ArrayDeque;
import java.util.Deque;

/*
1.类方法经典使用场景
    当方法中不涉及任何对象相关的成员时，可设计为静态方法以提高开发效率，典型场景是工具类中的方法，例如：
    Java 中的Math类、Arrays类、Collections集合类（可查看其源码）。
2.小结
    实际开发中，常将通用方法设计为静态方法，无需创建对象即可直接使用，比如：
    打印一维数组的方法
    冒泡排序方法
    特定计算任务的方法
* */
public class StaticMethod {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        Student tom = new Student("Tom");
        tom.payFee(100);
        Student jack = new Student("Jack");
        jack.payFee(200);

        //输出总学费
        Student.showFee();

        //sqrt是Math类中的静态方法
        System.out.println(Math.sqrt(9));
    }
}

class Student {
    //创建静态变量，累计学费
    private static double fee = 0.0;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    //1.该方法使用static修饰后，就是静态方法
    //2.静态方法就可以访问静态变量
    public static void payFee(double fee) {
        Student.fee += fee;
    }

    public static void showFee() {
        System.out.println("总学费：" + Student.fee);
    }
}
