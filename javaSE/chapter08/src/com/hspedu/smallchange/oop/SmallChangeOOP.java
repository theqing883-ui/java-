package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeOOP {
    // 属性
    //定义相关变量

    // 1.先完成菜单，并选择菜单，给出对于提示
    Scanner sc = new Scanner(System.in);
    boolean loop = true;
    String key = "";

    // 2.完成零钱通明细
    String details = "-----------------零钱通明细-----------------";

    // 3.完成收益入账
    double money = 0;
    double balance = 0;
    Date date = null;//Data 是java.util的一个类，表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");//可以用于日期格式化的

    //4.完成消费
    // double cost = 0;
    String location = null;

    //主菜单
    public void mainMenu() {
        do {

            System.out.println("\n=============零钱通菜单(OOP)==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消   费");
            System.out.println("\t\t\t4 退   出");
            System.out.print("请选择1~4：");
            key = sc.next();
            switch (key) {
                case "1": {
                    this.detail();
                    break;
                }
                case "2": {
                    this.income();
                    break;
                }
                case "3": {
                    this.payment();
                    break;
                }
                case "4": {
                    // 尽量一段代码写一个小功能，尽量不要把功能混在一起，便于阅读和维护
                    //先循环询问
                    this.exit();
                    break;
                }
                default:
                    System.out.println("输入有误，请重新选择");
            }
        } while (loop);
        System.out.println("-------------退出了零钱通--------------");
    }

    //零钱通明细
    public void detail() {
        System.out.println(details);
    }

    // 收益入账
    public void income() {
        System.out.println("收益入账金额：");
        money = sc.nextDouble();
        // money的值需要校验
        // 1.找出不正确金额的条件，给出提示，然后退出【校验编程思想，过关斩将校验法】
        if (money <= 0) {
            System.out.println("收益金额需要大于0！");
            return;//switch里面的break;在方法中换成return
        }
        balance += money;
        date = new Date();
        details += "\n" + "收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额：" + balance;//拼接入账信息
    }

    public void payment() {
        System.out.println("消费金额：");
        money = sc.nextDouble();
        // money的值需要校验
        if (money > balance || money <= 0) {
            System.out.println("消费金额应该在 0-" + balance);
            return;
        }
        balance -= money;
        date = new Date();
        System.out.println("消费地点：");
        location = sc.next();
        // 字符串拼接，换行符"\n"用在开头，不要用在结尾
        details += "\n" + location + "\t-" + money + "\t" + sdf.format(date) +
                "\t余额：" + balance;

    }

    public void exit() {
        String choice;
        do {
            System.out.println("你确定要退出吗？y/n");
            choice = sc.next();
        } while (!"y".equals(choice) && !"n".equals(choice));
        // 退出循环后再判断
        if (choice.equals("y")) {
            loop = false;
        }
    }


 /*   Scanner sc = new Scanner(System.in);
    boolean loop = true;
    String key = "";
    String choice;

    // 2.完成零钱通明细
    String details = "-----------------零钱通明细-----------------";
    // 3.完成收益入账
    double money = 0;
    double balance = 0;
    Date date = null;//Data 是java.util的一个类，表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");//可以用于日期格式化的

    //4.完成消费
    String location = null;

    public void menu() {
        do {

            System.out.println("\n=============零钱通菜单==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消   费");
            System.out.println("\t\t\t4 退   出");
            System.out.print("请选择1~4：");
            key = sc.next();
            function();
        } while (loop);
        System.out.println("-------------退出了零钱通--------------");
    }

    public void function() {
        switch (key) {
            case "1": {
                detail();
                break;
            }
            case "2": {
                income();
                // money的值需要校验
                // 1.找出不正确金额的条件，给出提示，然后退出【校验编程思想，过关斩将校验法】
                if (money <= 0) {
                    System.out.println("收益金额需要大于0！");
                    break;
                }
                deal(money);
                break;
            }
            case "3": {
                spend();
                // money的值需要校验
                if (money > balance || money <= 0) {
                    System.out.println("消费金额应该在 0-" + balance);
                    break;
                }
                System.out.println("消费地点：");
                location = sc.next();
                deal(money,location);

                break;
            }
            case "4": {
                // 尽量一段代码写一个小功能，尽量不要把功能混在一起，便于阅读和维护
                //先循环询问
                exit_();
                // 退出循环后再判断
                if (choice.equals("y")) {
                    loop = false;
                    break;
                }
            }
            default:
                System.out.println("输入有误，请重新选择");
        }
    }

    public void detail() {
        System.out.println(details);
    }
    public void income(){
        System.out.println("收益入账金额：");
        money = sc.nextDouble();
    }
    public void spend(){
        System.out.println("消费金额：");
        money = sc.nextDouble();
    }
    public void deal(double money){
        balance += money;
        date = new Date();
        details += "\n" + "收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额：" + balance;//拼接入账信息
    }
    public void deal(double money, String location){
        balance -= money;
        date = new Date();
        // 字符串拼接，换行符"\n"用在开头，不要用在结尾
        details += "\n" + location + "\t-" + money + "\t" + sdf.format(date) +
                "\t余额：" + balance;
    }
    public void exit_(){
        do {
            System.out.println("你确定要退出吗？y/n");
            choice = sc.next();
        } while (!"y".equals(choice) && !"n".equals(choice));
    }
*/


}
