package com.use;

import com.xiaoqiang.Dog;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);
        com.xiaoming.Dog dog1 = new com.xiaoming.Dog();
//        因为包com.xiaoming和com.xiaoqing的包里面都有Dog()类，
//        因此在使用com.xiaoming包里面的Dog时需要把包名带上，用于区分
        System.out.println(dog1);

    }
}
