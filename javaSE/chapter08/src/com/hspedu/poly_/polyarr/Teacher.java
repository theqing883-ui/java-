package com.hspedu.poly_.polyarr;

public class Teacher extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, double salary, int age) {
        super(age,name);
        this.salary = salary;
    }

    public String say(){
        return super.say() + "\t" + salary;
    }
    //特有的方法
    public void teach() {
        System.out.println("老师 " + getName() + "正在上课 ");
    }
}
