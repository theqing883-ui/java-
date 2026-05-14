package com.hsp.date;

import java.time.Instant;
import java.util.Date;

public class Instant_ {
    public static void main(String[] args) {
        //时间戳 类似第一代日期Date
        //1.获取当前时间戳对象
        Instant now = Instant.now();
        System.out.println(now);
        //2. Date.from()，Instant转为Date类
        Date date = Date.from(now);
        System.out.println(date);
        //3.Date.toInstant() Date转为Instant
        Instant instant = date.toInstant();
        System.out.println(instant);

    }
}
