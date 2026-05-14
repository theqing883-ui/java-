package com.hsp.generic_;
import java.util.ArrayList;
/*
泛型介绍
● int a = 10;
老韩理解: 泛(广泛)型(类型) => Integer,String,Dog
1) 泛型又称参数化类型, 是Jdk5.0出现的新特性.解决数据类型的安全性问题
2) 在类声明或实例化时只要指定好需要的具体的类型即可。
3) Java泛型可以保证如果程序在编译时没有发出警告, 运行时就不会产生
ClassCastException异常。同时, 代码更加简洁、健壮
4) 泛型的作用是: 可以在类声明时通过一个标识表示类中某个属性的类型, 或者是某个方
法的返回值的类型, 或者是参数类型。[有点难, 举例Generic03.java]
*
* */
public class Generic01 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
       /*
       arrayList.add(1);//只能添加泛型指定的<String>
       public class ArrayList<E> extends AbstractList<E>
        如果编译器发现类型不一致就会报错
        并且可以直接取出指定的类型<String>,不用再向下转型
        */
        arrayList.add("b");
        arrayList.add("c");
        for(String s : arrayList) {
            System.out.println(s);
        }
        /*
        泛型的理解和好处
        ● 使用传统方法的问题分析
        1) 不能对加入到集合ArrayList中的数据类型进行约束(不安全)
        2) 遍历的时候，需要进行类型转换,如果集合中的数据量较大，对效率有影响
        * */

        Person<String> person = new Person<String>("问哈撒");
        System.out.println(person.name.getClass());//String
        Person<Integer> person1 = new Person<Integer>(12121);
        System.out.println(person1.name.getClass());//Integer

    }
}
/*
泛型的作用是: 可以在类声明时通过一个标识表示类中某个属性的类型,
 或者是某个方法的返回值的类型, 或者是参数类型。
* */
class Person<E> {//该E的具体类型，是在定义对象时指定的，
                // 即在编译期间，确定E是什么类型
    E name;
    Person(E name) {
        this.name = name;
    }
    public E f(){
        return name;
    }
}
