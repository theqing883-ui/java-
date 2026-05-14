package com.hspedu.exercise.homework13;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    //父类基本信息+新的信息
    public void printInfo() {
        System.out.println("老师的信息：");
        System.out.println(super.info());
        System.out.println("工龄：" + work_age);
        System.out.println(this.play());
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                ", 工龄：" + work_age +
                '}';
    }
}
