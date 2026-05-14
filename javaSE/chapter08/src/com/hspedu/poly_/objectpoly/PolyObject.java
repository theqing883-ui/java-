package com.hspedu.poly_.objectpoly;

/* 对象多态
1.一个对象的编译类型和运行类型可以不一致
2.编译类型在定义对象时，就确定了，不能改变
3.运行类型是可以变化的
4.编译类型看定义时 = 号的左边，运行类型看 = 号的右边
 */
public class PolyObject {
    public static void main(String[] args) {
        // 对象多态

        Animal animal = new Dog();
        // 编译类型为Animal 运行类型为Dog
        animal.cry();//此时animal的运行类型为Dog(),
        // 因此调用Dog()里面的cry()

        animal = new Cat();
        // 编译类型为Animal 运行类型为Cat
        animal.cry();//此时animal的运行类型为Cat(),
        // 因此调用Cat()里面的cry()


    }
}
