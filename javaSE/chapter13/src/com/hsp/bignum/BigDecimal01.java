package com.hsp.bignum;

import java.math.BigDecimal;

public class BigDecimal01 {
    public static void main(String[] args) {
        double d = 1.99999999999999999;
        System.out.println(d);
        //当需要保存一个精度很高的数，double不够时，采用BigDecimal
        BigDecimal b = new BigDecimal("1.9999999999999999");
        BigDecimal b1 = BigDecimal.valueOf(d);
        BigDecimal b2 = new  BigDecimal("2");

        //对BigDecimal进行四则运算，需要使用专用方法
        /* 先将要操作的数都转为 BigDecimal 类型的
        * */
        //add()
        System.out.println(b.add(b1));
        System.out.println(b.subtract(b2));
        System.out.println(b.multiply(b2));

        /*
        * b2 : 除数
        * BigDecimal.ROUND_CEILING：保留和除数一样的精度
        * */
        System.out.println(b.divide(b2, BigDecimal.ROUND_CEILING));

    }
}
