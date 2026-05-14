package com.hspedu.exercise;

public class Homework04 {
    public static void main(String[] args) {
        Employee employee = new OrdinaryEmployee("Smith", 800, 20, 1);
        Employee employee2 = new Manager("wangdefa", 1000, 20, 1.2);
        ((Manager)(employee2)).setBonus(3000);

        employee.display();
        employee2.display();


    }
}

class Employee {
    private String name;
    private double salary;
    private int days;
    private double level;

    public Employee() {
    }

    public Employee(String name, double salary, int days, double level) {
        this.name = name;
        this.salary = salary;
        this.days = days;
        this.level = level;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(this.name + "的工资: " + this.salary * days * level);
    }
}

class OrdinaryEmployee extends Employee {
    public OrdinaryEmployee(String name, double salary, int days, double level) {
        super(name, salary, days, level);
    }

    public void display() {
        super.display();
    }
}

class Manager extends Employee {
    private double bonus;
    //经理的奖金不固定，构造器创建对象时不初始化
    public Manager(String name, double salary, int days, double level) {
        super(name, salary, days, level);
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void display() {
        System.out.println(this.getName() + "的工资: " + (this.getSalary() * this.getDays()* getLevel() + bonus));
    }

}