package com.hspedu.debug;

import java.util.Arrays;

// 演示执行到下一断点，同时支持动态下断点
public class Debug04 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 20, 10, 200};
        //Debug过程中查看源码，查看sort的源码
        Arrays.sort(arr);
        // 按F9,回到这个断点？可能是因为这里的for循环被看做多个断点
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            System.out.println("****");
        }


        System.out.println("Hello100");
        System.out.println("Hello200");
        System.out.println("Hello300");
        System.out.println("Hello400");
        System.out.println("Hello500");
        System.out.println("Hello600");
        System.out.println("Hello700");

    }
}
