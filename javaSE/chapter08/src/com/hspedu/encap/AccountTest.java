package com.hspedu.encap;

/*
包：com.hspedu.encap
包含文件：AccountTest.java 和 Account.java
创建程序，在其中定义两个类：Account 和 AccountTest 类，体会 Java 的封装性。
Account 类要求具有属性：
姓名（长度为 2 位、3 位或 4 位）
余额（必须 > 20）
密码（必须是六位）
如果不满足要求，则给出提示信息，并给默认值（由程序员自己设定）。
● 通过 setXxx 的方法给 Account 的属性赋值。
在 AccountTest 中进行测试。
*/


public class AccountTest {
    public static void main(String[] args) {
        Account wah = new Account("wah", 2.2, "00861");

        System.out.println(wah.info());
    }
}
