package com.hspedu.pkg;

import java.util.Arrays;

// 建议使用哪个类就导入哪个类[方式1]
//import java.util.Scanner;// 表示只会引入java.util包下的Scanner类
//import java.util.*;// 表示引入java.util包里面的所有类
// 注意：引入包语句的末尾有 ; 号
public class Import01 {
    public static void main(String[] args) {
    int[] a = {-1,2,3,4,5};
//    传统方法：自己编写
//      包方法
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
