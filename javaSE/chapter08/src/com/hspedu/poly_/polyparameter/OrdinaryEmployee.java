package com.hspedu.poly_.polyparameter;

public class OrdinaryEmployee extends Employee{
    public OrdinaryEmployee(String name, double salaryMonth) {
        super(name, salaryMonth);
    }



    public void work(){
        System.out.println("普通员工"+ this.getName() + "正在工作");
    }
    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
