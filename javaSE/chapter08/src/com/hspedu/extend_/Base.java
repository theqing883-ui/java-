package com.hspedu.extend_;

public class Base extends TopBase{
    //    四个不同修饰符的属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base() {// 无参构造器
        System.out.println("Base Constructor");
    }
    public Base(String name, int age){
        System.out.println(" Base(String name, int age) Constructor");
    }
    public Base(String name){
        System.out.println(" Base(String name) Constructor");
    }

    //    在父类提供一个public的方法，来访问私有属性和方法
    public int getN4() {
        return n4;
    }

    //    四个不同修饰符的方法
    public void test100() {
        System.out.println("Base test100");
    }

    protected void test200() {
        System.out.println("Base test200");
    }

    void test300() {
        System.out.println("Base test300");
    }

    private void test400() {
        System.out.println("Base test400");
    }

    public void callTest400(){
        test400();
    }
}
