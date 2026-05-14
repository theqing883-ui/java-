package com.shp.Collections_;

import java.util.ArrayList;
import java.util.Collections;
/*
 *
 * */
public class Collections01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /*
            **Collections工具类**

            ● Collections工具类介绍
            1) Collections 是一个操作 Set、List 和 Map 等集合的工具类
            2) Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作

            ● 排序操作:（均为static方法）
            1) reverse(List): 反转 List 中元素的顺序
            2) shuffle(List): 对 List 集合元素进行随机排序
            3) sort(List): 根据元素的自然顺序对指定 List 集合元素按升序排序
            * 自然顺序:按照字符串大小【比较ASCII码】排
            4) sort(List, Comparator【匿名内部类】): 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
            5) swap(List, int, int): 元索和 j 处元素进行交换



            1) Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
            2) Object max(Collection, Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
            3) Object min(Collection)
            4) Object min(Collection, Comparator)
            5) int frequency(Collection, Object)：返回指定集合中指定元素的出现次数
            6) void copy(List dest, List src)：将src中的内容复制到dest中
            *
            7) boolean replaceAll(List list, Object oldVal, Object newVal)：使用新值替换 List 对象的所有旧值
        * */
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        ArrayList dest = new ArrayList(5);
        //IndexOutOfBoundsException，需要给dest先赋值，个数大于等于list一样
        dest.add("H");
        dest.add("K");
        dest.add("M");
        dest.add("V");
        dest.add("W");
        Collections.copy(dest, list);
        System.out.println(dest);

        Collections.replaceAll(list,"A","a");
        System.out.println(list);
    }
}
