package com.hspedu.homework;

public class Homework05 {
    public static void main(String[] args) {
        new A().f();
    }
}

class A {
    private final String name = "earth";

    public void f() {
        class B {
            private final String name = "world";

            public void show() {
                System.out.println(name);
                System.out.println(A.this.name);
            }
        }
        new B().show();
    }
}
