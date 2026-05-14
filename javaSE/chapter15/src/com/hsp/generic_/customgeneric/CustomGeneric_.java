package com.hsp.generic_.customgeneric;

/*
自定义泛型
● 自定义泛型类（难度）
▷ 基本语法
class 类名<T, R...> { //...表示可以有多个泛型
成员
}
▷ 注意细节
1) 普通成员可以使用泛型（属性、方法）
2) 使用泛型的数组，不能初始化
3) 静态方法中不能使用类的泛型
4) 泛型类的类型，是在创建对象时确定的(因为创建对象时，需要指定确定类型)
5) 如果在创建对象时，没有指定类型，默认为Object
* */
public class CustomGeneric_ {
    public static void main(String[] args) {

    }
}

class T<E, T, V> {//自定义泛型类
    String name;
    E e;
    V v;
    T[] t ;//使用泛型的数组，不能初始化,因为具体类型不知道，所以无法确定在内存中开辟多大空间
    //static E e;//因为静态在类加载的时候可能触发了，而泛型要在类的实例化时才知道具体类型


    public T(String name, E e, V v, T[] t) {
        this.name = name;
        this.e = e;
        this.v = v;
        this.t = t;
    }

    public static void f() {
        //System.out.println(e);//静态方法不能使用泛型
        //因为静态在类加载的时候可能触发了，而泛型要在类的实例化时才知道具体类型
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
