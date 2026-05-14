package com.hspedu.extend_;
//模拟大学生考试情况
public class Graduate {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }
    public void testing() {
        System.out.println("大学生"+ this.name +"正在考高数");
    }
    public void print() {
        System.out.println("名字 "+ this.name +" 年龄 "+ this.age +" 成绩 "+ this.score);
    }
}
