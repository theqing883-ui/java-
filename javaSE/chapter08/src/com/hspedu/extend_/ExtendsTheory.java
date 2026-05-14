package com.hspedu.extend_;

/*
 *讲解继承的本质
 *  */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();
        /*
        * 当访问属性和方法这时要注意，要按照查找关系来返回信息
        * 1. 首先看子类是否有这个属性
        * 2. 如果子类有并且可以访问【不可访问就会报错】，则返回该信息
        * 3. 如果没有这个属性，就看父类有没有这个属性
        * 4. 如果父类有并且可以访问【不可访问就会报错】，就返回该信息
        * 5. 如果父类没有就按照[3、4]的的规则，继续向上寻找，直到Object...
        *    如果都没，就会报错
        * */

        System.out.println(son.name);
        System.out.println(son.age);
        System.out.println(son.hobby);
    }
}

class Grandpa {//爷类
    String name = "大头爷爷";
    String hobby = "旅游";
}

class Father extends Grandpa {//父类
    String name = "大头爸爸";
    int age = 39;
}

class Son extends Father {// 子类
    String name = "大头儿子";
//    private String name = "大头儿子";//会报错
}
