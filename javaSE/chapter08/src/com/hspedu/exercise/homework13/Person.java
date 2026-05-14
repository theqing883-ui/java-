package com.hspedu.exercise.homework13;

public class Person {
    private String name;
    private int age;
    private String sex;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String play() {
        return (this.name + "爱玩");

    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' ;
    }



    //父类基本信息
    public String info() {
        return "姓名：" + this.getName() + "\n" + "年龄：" + this.getAge() +
                "\n" + "性别：" + this.getSex();
    }
}
