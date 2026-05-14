package com.hspedu.exercise;

public class Homework02 {
/*
public 随时随地可以访问
protected 不同包且不是子类时不可以访问，不同包且是子类时可以访问，同包不管是不是子类都能访问
默认 不同包且不是子类时不可以访问，不同包且是子类时不可以访问，同包不管是不是子类都能访问
private 只有本类才能访问，
访问修饰符	同类	   同包	  子类(同包)	 子类(不同包)    	不同包非子类
public	    ✓	    ✓	    ✓	         ✓	         ✓
protected	✓	    ✓	    ✓	         ✓	         ❌
默认	        ✓	    ✓	    ✓	         ❌   	     ❌
private 	✓	    ❌	    ❌	         ❌	         ❌

* */
}
class test {
    public int a = 0;
    protected int b = 0;
    int c = 0;
    private int d = 0;
}