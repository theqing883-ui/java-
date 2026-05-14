package com.hspedu.interface_;

public interface AInterface {
    public int n1 = 0;

    //在接口中。抽象方法可以省略abstract关键字
    public void hi();

    //在JDK8及以后可以有默认方法(需要用default声明)和静态方法
    // 注意：这里的 default 不是访问修饰符，
    // 是 Java 8 引入的新特性，用于在接口中定义具有实现的方法
    default public void ok(){
        System.out.println("say ok~~~");
    }

    public static void say(){
        System.out.println("say hello~~~");
    }

}
