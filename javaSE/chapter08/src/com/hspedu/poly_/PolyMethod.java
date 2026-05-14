package com.hspedu.poly_;
/*
1) 方法的多态PloyMethod.java
   重写和重载就体现多态[案例说明：]
*/
public class PolyMethod {
    public static void main(String[] args) {
    // 方法重载体现多态
        A a = new A();
        a.sum(1,2);
        a.sum(1,2,3);
    // 方法重写【覆盖】体现多态
        B b = new B();
        b.say();
        a.say();

    }
}

class B {
    public void say() {
        System.out.println("B say() 被调用");
    }
}

class A extends B {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    public void say() {
        System.out.println("A say() 被调用");
    }
}
