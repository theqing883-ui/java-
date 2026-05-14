package com.hsp.system_;

import java.util.Arrays;

public class System01 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        /*
        1.exit(0) 表示退出
        2.0 表示一个状态，正常状态
        * */
//        System.exit(0);
        System.out.println("Hello World11212");

        int[] src = {1,2,3};
        int[] dest = new int[3];//[0,0,0]
        /* System.arraycopy [Arrays.copyOf的底层]
        形参:
            src – the source array.【源数组】
            srcPos – starting position in the source array.
            【从原数组的第srcPos个索引开始拷贝】
            dest – the destination array.
            【目标数组】
            destPos – starting position in the destination data.
            【把源数组的元素，拷贝到目标数组的第destPos索引】
            length – the number of array elements to be copied.
            【从源数组拷贝length个元素到目标数组】
        * */
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(dest));

        //currentTimeMillens : 返回当前时间距离1970年-1-1的毫秒数
        System.out.println(System.currentTimeMillis());
        //System.gc()：运行垃圾回收机制

    }
}
