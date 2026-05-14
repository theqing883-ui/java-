package com.hspedu.homework.homework04;

public class Cellphone {

    public void testWork(Interface IA, double n1, double n2) {
        double res = IA.work(n1, n2);
        System.out.println("res: " + res);
    }
}

class Test {
    public static void main(String[] args) {
        new Cellphone().testWork(new Interface() {
            @Override
            public double work(double n1, double n2) {

                return n1 + n2;
            }
        }, 10, 8);
    }
}
