package com.hspedu.exercise;

public class Homework05 {
    public static void main(String[] args) {
        Worker worker = new Worker(9000, "jjbo");
        Peasant peasant = new Peasant(5000, "wamgdefa");
        Waiter waiter = new Waiter(7000, "chilll");
        Teacher1 teacher = new Teacher1(8000, "刘套", 300, 200);
        Scientist scientist = new Scientist(10000, "Smith", 20000);
//        System.out.println(worker.getSalary());
//        System.out.println(peasant.getSalary());
//        System.out.println(waiter.getSalary());
//        System.out.println(teacher.getSalary());
//        System.out.println(scientist.getSalary());
        worker.printYearSal();
        peasant.printYearSal();
        waiter.printYearSal();
        teacher.printYearSal();
        scientist.printYearSal();

    }
}

class Employee1 {
    private String name;
    private double salary;
    private int salMonth = 12;

    public Employee1(double salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    public void printYearSal() {
        System.out.println(this.name + "的年薪为" + this.salary * this.salMonth);
    }
}

class Worker extends Employee1 {
    public Worker(double salary, String name) {
        super(salary, name);
    }
}

class Peasant extends Employee1 {
    public Peasant(double salary, String name) {
        super(salary, name);
    }
}

class Waiter extends Employee1 {
    public Waiter(double salary, String name) {
        super(salary, name);
    }
}

class Teacher1 extends Employee1 {
    private int days;
    private double teachFee;

    public Teacher1(double salary, String name, int days, double teachFee) {
        super(salary, name);
        this.days = days;
        this.teachFee = teachFee;
    }

    public void printYearSal() {
        System.out.println(this.getName() + "的年薪为" + (this.getSalary() * this.getSalMonth() + this.days * this.teachFee));
    }
}

class Scientist extends Employee1 {
    private double bonus;

    public Scientist(double salary, String name, double bonus) {
        super(salary, name);
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public void printYearSal() {
        System.out.println(this.getName() + "的年薪为" + (this.getSalary() * this.getSalMonth() + bonus));
    }
}
