package com.hspedu.debug;

public class Debug02 {
    public static void main(String[] args) {
        int[] arr = {1,10,11};
        //数组越界异常
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("退出for循环~~~");
    }
}
