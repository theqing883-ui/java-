package com.hsp.math_;

public class Math01 {
    public static void main(String[] args) {
        Math01 m = new Math01();
        //match的常用方法：大多都为静态方法
        //abs
        System.out.println(Math.abs(-1));
        //求幂 pow
        System.out.println(Math.pow(4, -1));
        //ceil（天花板） 向上取整
        System.out.println(Math.ceil(-4.1));
        //floor(地板) 向下取整
        System.out.println(Math.floor(-4.1));
        //round 四舍五入 等价于 Math.floor(该参数+0.5)
        System.out.println(Math.round(4.4));
        //sqrt()
        System.out.println(Math.sqrt(-4));
        //random 返回[0~1）的随机数
        System.out.println(Math.random());

        //max 、min返回最大值和最小值
        System.out.println(Math.max(3,2));
        System.out.println(Math.min(3,2));


    }
}
