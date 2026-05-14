package com.hspedu.debug;

/*Debug过程中查看源码 F7*/

/* 断点调试案例 3 相关内容提取：
核心目的：演示如何追源码，了解 Java 设计者的实现思路，提升编程思想。
小技巧：将光标放在某个变量上，可以查看该变量的最新数据。
对应文件：Debug03.java */
import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 20, 10, 200};
        //Debug过程中查看源码，查看sort的源码
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
