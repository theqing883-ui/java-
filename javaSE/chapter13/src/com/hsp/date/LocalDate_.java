package com.hsp.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期
        //1.使用now() 返回吧表示当前日期+时间的对象

        //   DateTimeFormat 类对LocalDateTime进行格化
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String dateTime1 = formatter.format(dateTime);
        System.out.println("格式化后：" + dateTime1);


        System.out.println(dateTime);
        System.out.println(dateTime.getYear());//获取年
        System.out.println(dateTime.getMonthValue());//获取月（数字）
        System.out.println(dateTime.getMonth());//获取月（英文）
        System.out.println(dateTime.getDayOfMonth());//获取日
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.getMinute());
        System.out.println(dateTime.getSecond());

        //2.用now()，获取年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //3.用now()获取时分秒
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);


        //提供了 plus 和 minus方法可以对当前时间进行加会减 还有很多其他方法
        System.out.println("==============================");
        LocalDateTime localDateTime = dateTime.plusDays(890);//890天后是几月几日

        System.out.println(formatter.format(localDateTime));

        LocalDateTime localDateTime1 = dateTime.minusMinutes(34232);
        System.out.println(formatter.format(localDateTime1));

    }
}
