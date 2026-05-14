package com.hsp.array_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayMethod {
    public static void main(String[] args) {
        Integer[] a = {1, 20, 90};
        //使用toString方法输出
        System.out.println(Arrays.toString(a));

        //sort 排序
        /*
        1、因为数组是引用类型，所以排序号后，会直接影响到原数组
        2、sort 默认排序是从小到大
        3、sort 被重载的，可以传入一个接口Comparator 指定排序规则
        4、定制排序时，需传入两个参数，一是：需要排序的数组，二是：实现Comparator
            接口的匿名内部类，要求实现compare 方法
         5、这里体现了接口编程方式，看源码
        * */
        Integer[] b = {1, -1, 7, 0, 89};
        Arrays.sort(b);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(b));

        Arrays.sort(b, new Comparator() {//匿名内部类
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(b));

    }
}
