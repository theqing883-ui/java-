package com.hspedu.poly_.polyparameter;

public class Employee {
    private String name;
    private double salaryMonth;

    public Employee(String name, double salaryMonth) {
        this.name = name;
        this.salaryMonth = salaryMonth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(double salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public double getAnnual() {
        return salaryMonth * 12;
    }
}
