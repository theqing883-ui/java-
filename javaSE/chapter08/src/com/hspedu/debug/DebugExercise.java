package com.hspedu.debug;

//debug对象创建过程
public class DebugExercise {
    public static void main(String[] args) {
        //1.加载类信息，2.默认初始化，3.显示初始化，4.构造器初始化，5.返回地址给引用
        Person jake = new Person("jake", 20);
        System.out.println(jake);
    }
}
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}