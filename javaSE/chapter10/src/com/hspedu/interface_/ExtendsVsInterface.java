package com.hspedu.interface_;

/*1.接口（interface）和抽象类(abstract class)有点类似，可以说接口是一种特殊的抽象类
2.实现（implements）和继承有点类似，可以说实现就是一种特殊的继承
3.类实现了接口后，就继承了接口的属性和方法（同样受到访问修饰符，static,final的限制）*/


/*继承类vs实现接口
小结： 当子类继承了父类，就自动的拥有父类的功能
      如果子类需要扩展功能，可以通过实现接口的方式扩展。
      可以理解 实现接口 是 对java 单继承机制的一种补充。*/

/*
# 接口
- **实现接口 vs 继承类**
  - **接口和继承解决的问题不同**
    继承的价值主要在于：解决代码的**复用性**和**可维护性**。
    接口的价值主要在于：**设计**，设计好各种规范(方法)，让其它类去实现这些方法。即更加地灵活。

  - **接口比继承更加灵活**
    接口比继承更加灵活，继承是满足 **is - a** 的关系，而接口只需满足 **like - a** 的关系。

  - **接口在一定程度上实现代码解耦**

* */

//鱼
interface Fishable {
    void swimming();
}

//鸟
interface Bird {
    void flying();
}

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuk = new LittleMonkey("悟空");
        wuk.climbing();
        wuk.swimming();
        wuk.flying();
    }
}

//猴子
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + "Monkey climbing");
    }
}

//小猴子
class LittleMonkey extends Monkey implements Fishable, Bird {
    public LittleMonkey(String name) {
        super(name);
    }

    public void swimming() {
        System.out.println("向小鱼学会了游泳！");
    }

    public void flying() {
        System.out.println("向小鸟一样学会了飞行！");
    }
}