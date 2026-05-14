package com.hsp.generic_.customgeneric;

interface User<E, T, U> {
    int age = 11;// public static final

    //E e;//静态成员也不能使用泛型
    void setAge(int age);//public abstract

    default void show() {

        System.out.println(age);
    }

    public default void defaultProcess() {
        // 两个修饰符各有作用：
        // 1. public - 访问修饰符（控制谁能访问）
        // 2. default - 标识这是默认方法（有默认实现）
    }
}

interface asd extends User<Integer, Integer, Integer> {

}

public class CustomInterfaceGeneric_ {
    public static void main(String[] args) {
        /*
        自定义泛型
        ● 自定义泛型接口
        ▷ 基本语法
        interface 接口名<T, R...> {
        •}
        ▷ 注意细节
        1) 接口中, 静态成员也不能使用泛型(这个和泛型类规定一样)
        2) 泛型接口的类型, 在继承接口或者实现接口时确定
        3) 没有指定类型, 默认为Object
        * */
    }
}