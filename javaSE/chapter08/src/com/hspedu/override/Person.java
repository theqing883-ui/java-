package com.hspedu.override;

public class Person {
    private String name;
    private int age;
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void say(){
        System.out.print("Person Information \n"
                + "姓名： " + name + " 年龄： " + age);
    }
}
