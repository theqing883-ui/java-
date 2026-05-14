package com.hsp.bignum;

import java.math.BigInteger;

public class BIigInteger_ {
    public static void main(String[] args) {
        long l = 1219210393;
        System.out.println(l);
        //当需要处理很大的整数时，long不够使用，就可以使用BigInteger
        BigInteger bi = new BigInteger("1212323121213313121213243435434121");
        BigInteger bi1 = BigInteger.valueOf(l);
        System.out.println(bi);
        //对BigInteger进行四则运算，需要使用专用方法
        /* 先将要操作的数都转为 BigInteger类型的
        1.加 add()
        * */
        BigInteger add = bi.add(bi1);
        System.out.println(add);
        BigInteger sub = bi.subtract(bi1);
        System.out.println(sub);
        BigInteger mul = bi.multiply(bi1);
        System.out.println(mul);
        BigInteger di = bi.divide(bi);
        System.out.println(di);
        System.out.println(bi);



    }
}
