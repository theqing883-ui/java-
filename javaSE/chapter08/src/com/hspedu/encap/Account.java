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


public class Account {
    public String name;
    private double balance;
    private String password;
    public Account(String name,double balance,String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public Account() {
    }

    public void setName(String name){
        if(name.length() >= 2 && name.length() <= 4){
            this.name = name;
        }else{
            System.out.println("输入姓名不符合要求，给默认为null");
            this.name = "";
        }
    }
    public void setBalance(double balance ){
        if(balance > 20){
            this.balance = balance;
        }else{
            System.out.println("账号余额小于20");
            this.balance = 19;
        }
    }
    public void setPassword(String password){
        if(password.length() == 6){
            this.password = password;
        }else{
            System.out.println("密码必须为6位，默认密码为000000");
            this.password = "000000";
        }
    }
    public String info(){
        System.out.println(this.name +"账户信息");
        return "name "+name+" balance "+balance+" password "+password;
    }
}
