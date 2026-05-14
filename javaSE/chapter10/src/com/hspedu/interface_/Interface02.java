package com.hspedu.interface_;
/*
# 接口
- **基本介绍**
接口就是给出一些没有实现的方法，封装到一起，到某个类要使用的时候，再根据具体情况把这些方法写出来。
interface 接口名{
    //属性
    //方法(1.抽象方法 2.默认实现方法 3.静态方法)
}

java
class 类名 implements 接口{
    自己属性;
    自己方法;
    必须实现的接口的抽象方法
}
- **小结：**
1. 在Jdk7.0前 接口里的所有方法都没有方法体，即都是抽象方法。
2. Jdk8.0后接口可以有静态方法，默认方法，也就是说接口中可以有方法的具体实现

* */
public class Interface02 {
    public static void main(String[] args) {

    }

}

//实现接口，就要实现接口的所有抽象方法
class A implements AInterface {
    public void hi() {
        System.out.println("hi");
    }

}