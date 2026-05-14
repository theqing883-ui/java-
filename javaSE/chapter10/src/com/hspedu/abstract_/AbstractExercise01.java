package com.hspedu.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        new Manager("Smith",10000.0,"12345",20000).work();
        new CommonEmployee("jack",9000,"98765").work();
    }
}

abstract class Employee {
    protected String name;
    private double salary;
    private String id;

    public Employee(String name, double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void work();
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, String id, double bonus) {
        super(name, salary, id);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("经理 " + this.getName() + " 工作中。。。 ");
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, double salary, String id) {
        super(name, salary, id);
    }

    public void work() {
        System.out.println("普通员工 " + this.getName() + " 工作中... ");
    }
}