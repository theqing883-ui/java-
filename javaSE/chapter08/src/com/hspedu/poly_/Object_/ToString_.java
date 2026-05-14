package com.hspedu.poly_.Object_;

/*
基本介绍
1.默认返回格式：全类名+@+哈希值的十六进制（可查看Object的toString方法）。
2.子类通常会重写toString方法，用于返回对象的属性信息。

3.重写 toString 的作用
    重写后，打印对象或拼接对象时，会自动调用该对象重写后的toString形式。

4. 当直接输出一个对象引用时，toString方法会被默认调用。
* */

public class ToString_ {
    public static void main(String[] args) {
        /*
       Object的ToString方法
       1.getClass().getName() 返回全类名(包名 + 类名)
       2.Integer.toHexString(hashCode()) 将对象的hashCode值转为16进制
         public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
         }
        * */
        Monster monster = new Monster(1000000,"抓唐僧","猪刚鬣");
        System.out.println(monster.toString());
        // 未重写时调用的是Object的toString()方法
        // 重写后调用Monster的toString方法


        //4. 当直接输出一个对象引用时，toString方法会被默认调用。
        System.out.println(monster);
        // 默认调用toString方法

    }
}

class Monster {
    private String name;
    private String job;
    private double salary;

    public Monster(double salary, String name, String job) {
        this.salary = salary;
        this.name = name;
        this.job = job;
    }
    //重写toString方法,输出对象属性 使用快捷键 alt+insert

    @Override
    public String toString() {//一般是把对象属性输出
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
