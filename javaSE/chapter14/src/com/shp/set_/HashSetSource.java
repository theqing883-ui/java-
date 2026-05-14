package com.shp.set_;


/*
# Set接口实现类-HashSet
● HashSet底层机制说明
▶ 分析HashSet的添加元素底层是如何实现（hash()+equals()）
HashSetSource.java 先说说结论，再Debug源码+图解（前方高能）.

1. HashSet 底层是 HashMap
2. 添加一个元素时，先得到hash值→ 转成→ 索引值
3. 找到存储数据表table，看这个索引位置是否已经存放的有元素
4. 如果没有，直接加入
5. 如果有，调用equals 比较，如果相同，就放弃添加，如果不相同，则添加到最后
6. 如果在table中添加的元素（包括链表里的）超过threshold（*0.75），就进行扩容*2
7. 在Java8中，如果一条链表的元素个数到达 TREEIFY_THRESHOLD（默认是8），并且table的大小 >= 默MIN_TREEIFY_CAPACITY（默认64），就会进行树化（红黑树）

* */

import java.util.HashSet;
@SuppressWarnings({"all"})
public class HashSetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("java");//加在哪个位置由系统计算决定，hash值
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set=" + hashSet);

    }
}
