package com.hsp.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01{
    public static void main(String[] args) throws ParseException {
        //java.util.Date

        Date d1 = new Date();//获取当前系统时间
        System.out.println(d1);//国外格式时间
        // "yyyy-MM-dd HH:mm:ss" 格式使用的字母是规定好的
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d1));

        //Date(long)
        Date d2 = new Date(102102120);
        System.out.println(d2);

        //Date(格式化之后的字符串)
        /*
        1.可以把一个格式化的String 转为对应的 Date。
        2.Date 仍然在输出时，还是按照国外的格式，同样可以使用指定格式输出。
        3.String 的格式需要和SimpleDateFormat格式一样。
        * */
        String s1 ="2026-01-06 10:43:30 星期二";
        Date d3 = sdf.parse(s1);
        System.out.println(sdf.format(d3));
    }
}
