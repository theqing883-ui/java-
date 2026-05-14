package com.hspedu.annotation;

public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.print();
    }
}

/*
* 1.@Deprecated 修饰某个元素，表示该元素已经过时
* 2.即不在推荐使用，但是仍然可以使用
* 3.可以修饰 类，方法，字段、包、变量、构造器、参数等,不能注解代码块
* 【@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})】
* 4.@Depracted 可以做到新旧版本的兼容过度
* */

/*
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
}
* */

@Deprecated
class A {
    public int x = 10;
    public int y = 20;
    @Deprecated
    public void print() {}
}
