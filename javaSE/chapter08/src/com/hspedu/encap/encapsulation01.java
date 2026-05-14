package com.hspedu.encap;
//封装的介绍
/*封装（encapsulation）就是把抽象出的数据[属性]和对数据的操作[方法]封装在一起，
数据被保护在内部，程序的其它部分只有通过被授权的操作[方法]，才能对数据进行操作。

封装的理解和好处
1）隐藏实现细节：方法（连接数据库）<--调用（传入参数...）
2）可以对数据进行验证，保证安全合理

实现步骤（三步）
1）将属性进行私有化 private 【不能直接修改属性】
2）提供一个公共的（public）set 方法，用于对属性判断并赋值
3）提供一个公共的（public）get 方法，用于获取属性的值
*/

import jdk.nashorn.internal.ir.CallNode;

public class encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
//        person.age = 120; //不在同一个类 无法访问private
        person.setAge(20);
        person.setName("jake");
        person.setSalary(20000);
        System.out.println(person.info());
        Person person1 = new Person(20000, "Smith", 200);
        System.out.println(person1.info());

    }
}
/*
那么在java中如何实现这种类似的控制呢?
请大家看一个小程序(com.hspedu.encap: Encapsulation01.java),
不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，
否则给默认年龄, 必须在 1-120, 年龄， 工资不能直接查看 ， name的长度在 2-6字符
之间
*/

class Person {
    public String name;
    private int age;
    private double salary;

    //    构造器与setXxx结合
    public Person() {
    }

    public Person(double salary, String name, int age) {
//        this.salary = salary;
//        this.name = name;
//        this.age = age;
//        我们可以在构造器中调用setXxx方法进行赋予
        setSalary(salary);
        setName(name);
        setAge(age);
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("输入年龄不对，给默认年龄18");
            this.age = 18;
        }

    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //   自己写setXxx，getXxx太慢了，使用快捷键 Alt + Insert
//    然后根据要求完善代码
    public void setName(String name) {
        // 对数据校验
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名字长度不对，给默认名");
            this.name = "无名氏";
        }
    }

    // 返回信息
    public String info() {
        return "Name: " + name + " Age: " + age + " Salary: " + salary;
    }
}
