package com.hspedu.exercise.homework13;

public class Student extends Person {
    private int stu_id;

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习！");
    }

    public String play() {
        return super.play() + "足球";
    }

    //父类基本信息+新的信息
    public void printInfo() {
        System.out.println("学生的信息：");
        System.out.println(super.info());
        System.out.println("学号：" + stu_id);
        System.out.println(this.play());
    }
    public String toString() {
        return "Teacher{" + super.toString() +
                ", 学号：" + stu_id +
                '}';
    }

}
