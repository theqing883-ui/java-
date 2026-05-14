package com.hspedu.poly_.polyarr;

public class Student extends Person {
    private double score = 150;

    public Student(String name, double score, int age) {
        super(age,name);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public String  say(){

        return super.say() + "\t" + this.score;
    }
    // 特有的方法
    public void study(){
        System.out.println("学生" + getName() + "正在学习");
    }
}
