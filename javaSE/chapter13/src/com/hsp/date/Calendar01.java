package com.hsp.date;

import java.util.Calendar;

public class Calendar01 {
    public static void main(String[] args) {
        /*
        1.Calender 是一个抽象类，并且构造器是private
        2.可以通过getInstance() 来获取
        3.可以提供大量的方法和字段
        4.HOUR为12小时制，HOUR_OF_DAY为24小时制度
        * */

        Calendar c = Calendar.getInstance();//创建Calendar对象
        System.out.println("c " + c);
        //获取日历对象的磨沟日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        //因为这里的月是从0月开始的，因此要+1
        System.out.println("++++++++++++++++++++");
        System.out.println(Calendar.MONTH);
        /*
        Calendar.MONTH
        直接输出的是常量值2，而不是当前月份
        public final static int MONTH = 2;

        c.get(Calendar.MONTH) + 1;当前月份
         */
        System.out.println("月：" + c.get(Calendar.MONTH) + 1);
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒钟：" + c.get(Calendar.SECOND));
        //Calendar没有相应的格式化类，需要自己组合
        System.out.println("当前时间：" + c.get(Calendar.YEAR) +
                "-" + c.get(Calendar.MONTH) + 1 +
                "-" + c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) +
                ":" + c.get(Calendar.MINUTE));
    }
}
