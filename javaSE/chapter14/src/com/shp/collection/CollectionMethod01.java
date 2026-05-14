package com.shp.collection;
/*
# Collection接口和常用方法
● Collection接口实现类的特点
public interface Collection<E> extends **Iterable<E>**

1)collection实现子类可以存放多个元素,每个元素可以是Object
2)有些Collection的实现类, 可以存放重复的元素,有些不可以
3)有些Collection的实现类, 有些是有**序**的(List), 有些不是有序(Set)
4)Collection接口没有直接的实现子类, 是通过它的子接口Set 和 List 来实现的

要不要我帮你整理一份**Collection接口核心要点的简化笔记**？
* */

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        //add()
        list.add("a");
        list.add(10);//自动装箱
        System.out.println(list);
        //remove()
//        list.remove("a");
        list.remove(1);
        System.out.println(list);
        //contains查找元素是否存在
        System.out.println(list.contains("a"));
        //size
        System.out.println(list.size());
        //isEmpty判断是否为空
        System.out.println(list.isEmpty());
        //clear
        list.clear();
        System.out.println(list);
        //addAll添加多个元素
        ArrayList arrayList = new ArrayList();
        arrayList.add("sasa");
        arrayList.add(1213213);

        list.addAll(arrayList);
        System.out.println(list);
        //containsall:查找多个元素是否同时存在
        list.add(1212);
        System.out.println(list.containsAll(arrayList));
        //removeAll 删除多个元素
        list.removeAll(arrayList);
        System.out.println(list);
    }
}
