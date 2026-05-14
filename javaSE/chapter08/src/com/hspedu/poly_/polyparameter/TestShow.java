package com.hspedu.poly_.polyparameter;

public class TestShow {
    public void showEmpAnnual(Employee e){
        System.out.println(e.getName() +"的年薪"+ e.getAnnual());

    }
    public void showWork(Employee e){
        if(e instanceof OrdinaryEmployee){
            ((OrdinaryEmployee)e).work();
        }else if(e instanceof Manager){
            ((Manager)e).manage();
        }
    }
}
