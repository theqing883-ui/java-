package com.shp.list_;

import java.util.ArrayList;

public class ArrayListDetail {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(null);//可以存放空
        System.out.println(arrayList);

        /*
        # ArrayList底层结构和源码分析
        ● ArrayList的注意事项
        ArrayListDetail.java
        1) permits all elements, including null，ArrayList 可以加入null,并且多个
        2) ArrayList 是由数组来实现数据存储的
        3) ArrayList基本等同于Vector，除了 ArrayList是线程不安全(执行效率高) 看源码 没有synchronized.
        在多线程情况下，不建议使用ArrayList
        * */

        /*
        ● ArrayList的底层操作机制源码分析(重点，难点.)
        ArrayListSource.java，先说结论，在分析源码(示意图)

        1) ArrayList中维护了一个Object类型的数组elementData。[debug 看源码]
           `transient Object[] elementData;
           //transient 表示瞬间,短暂的,表示该属性不会被序列化`

        2) 当创建ArrayList对象时，如果使用的是无参构造器，
        则初始elementData容量为0，第1次添加，则扩容elementData为10，
        如需要再次扩容，则扩容elementData为1.5倍。

        3) 如果使用的是指定大小的构造器，则初始elementData容量为指定大小，
        如果需要扩容，则直接扩容elementData为1.5倍。
        * */

        //ArrayList list = new ArrayList();
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用for 给list 集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);

    }
}
