package com.hspedu.poly_.polyparameter;

public class Test {
    public static void main(String[] args) {
        TestShow testShow = new TestShow();
        Employee e1 = new OrdinaryEmployee("scote",9000);
        Employee e2 = new Manager("JAKE",10000,50000);


        testShow.showEmpAnnual(e1);
        testShow.showEmpAnnual(e2);
        testShow.showWork(e1);
        testShow.showWork(e2);
    }
}
