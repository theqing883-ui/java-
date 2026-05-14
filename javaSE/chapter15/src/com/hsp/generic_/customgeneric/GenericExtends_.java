package com.hsp.generic_.customgeneric;

/*
泛型的继承和通配符
● 泛型的继承和通配符说明 GenericExtends.java
1) 泛型不具备继承性
List<Object> list = new ArrayList<String>();// 对吗？
new 泛型类型
2) <?> : 支持任意泛型类型
3) <? extends A> : 支持A类以及A类的子类，规定了泛型的上限
4) <? super A> : 支持A类以及A类的父类，不限于直接父类，规定了泛型的下限

public static void printCollection1(List<?> c) {
* */
public class GenericExtends_ {
    public static void main(String[] args) {
        Object o = new String();

        // List<Object> list = new ArrayList<String>();
    }
}
