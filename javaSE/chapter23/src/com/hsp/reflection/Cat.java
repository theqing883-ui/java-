package com.hsp.reflection;

public class Cat {
    public String name = "招财猫";
    private int age = 100;

    public Cat(String name) {
        this.name = name;
    }
    public Cat() {}

    public void eat() {
        System.out.println("cat eat");
    }

    public int getAge() {
        return age;
    }
}
