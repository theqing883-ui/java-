package com.hsp.array_;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] a = {1,2,90,123,527};
        // binarySearch() 二叉查找法（二分法）
        /*
        1、要求该数组是有序的
        2、返回的是该元素在数组中的索引
        3、如果不存在则返回   return -(low + 1); low表示理论一个在的位置
        * */
        int index = Arrays.binarySearch(a, 92);
        System.out.println(index);

        //copOf 数组元素
        /*
        1、从a数组中复制arr.length个元素到b
        2、如果拷贝的长度 > a.length，则在新数组后面增加null
        3、如果拷贝的数组长度小于0 ，抛出异常NegativeArraySizeException
        * */
        Integer[] b = Arrays.copyOf(a, a.length-1);
        System.out.println(Arrays.toString(b));

        //fill 数组填充
        Integer[] c = {9,3,2};
        //使用指定元素替换原来的元素
        Arrays.fill(c,99);
        System.out.println("c填充后");
        System.out.println(Arrays.toString(c));

        //equals 比较两个数组元素是否完全一样
        //1、如果arr 和 arr2数组的元素一样，则返回true
        Integer[] arr = {1,2,3,4};
        Integer[] arr2 = {1,2,3,4};
        System.out.println(Arrays.equals(arr, arr2));


        //alist 将一组值，转换为List集合
        /*
        1、返回的编译类型 List (接口)
        2、运行类型 java.util.Arrays$ArrayList
        * */
        List list = Arrays.asList(1,2,3,4);
        System.out.println(list);
        System.out.println("list的运行类型：" + list.getClass());


    }
}
