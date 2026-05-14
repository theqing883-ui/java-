package com.hspedu.homework.homework03;

public abstract class Animal {
    public abstract void shout();
}

class Cat extends Animal {
    public void shout() {
        System.out.println("猫会喵喵叫");
    }
}

class Dog extends Animal {
    public void shout() {
        System.out.println("狗会旺旺叫");
    }
}

class Test {
    public static void main(String[] args) {
        Animal a = new Cat();
        Animal b = new Dog();

        a.shout();
        b.shout();
    }
}
