package com.hspedu.extend_.improve_;
//是Pupil和Graduate的父类
public class Student {
//    共有的属性
    public String name;
    public int age;
    private double score;

//    共有的方法
    public void setScore(double score) {
        this.score = score;
    }

    public void print() {
        System.out.println("名字 "+ this.name +" 年龄 "+ this.age +" 成绩 "+ this.score);
    }
}
