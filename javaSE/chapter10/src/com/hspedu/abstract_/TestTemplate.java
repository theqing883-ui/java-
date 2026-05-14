package com.hspedu.abstract_;

/*1.当多个方法有重复的代码块，且不连续时，可以把重复的代码块写成一个方法，在把不同的部分插入新写的方法中
 */

/*
* 抽象类最佳实践 - 模板设计模式● 最佳实践设计一个抽象类 (Template)，能完成如下功能:
编写方法 calculateTime ()，可以计算某段代码的耗时时间
编写抽象方法 job ()
编写一个子类 Sub，继承抽象类 Template，并实现 job 方法。
编写一个测试类 TestTemplate，看看是否好用。*/

public class TestTemplate {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.job();
        aa.CT();

        BB b = new BB();
        b.job();
        b.CT();
    }
}

