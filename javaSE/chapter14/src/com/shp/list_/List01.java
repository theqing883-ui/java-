package com.shp.list_;

import java.util.ArrayList;
import java.util.List;

/*
● List 接口基本介绍
List 接口是 Collection 接口的子接口 List.java
List 集合中的元素都有其顺序（添加顺序和取出顺序一致）、且可重复
List 集合中的每个元素都添加对应的顺序索引，即支持索引。
List 容器中的元素都对应一个整型的序号记录其在容器中的位置，可以根据序号存取容器中的元素。
JDK API 中 List 接口的实现类有：
接口 List<E>
所有超级接口:
Collection<E>, Iterable<E>
所有已知实现类:
AbstractList, AbstractSequentialList, ArrayList, AttributeList, CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector
常用的有: ArrayList、LinkedList 和 Vector.
* */
public class List01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List strings = new ArrayList();
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        strings.add("Python");
        strings.add("C++");
        strings.add("Python");
        //List 集合中的元素都有其顺序（添加顺序和取出顺序一致）、且可重复
        System.out.println(strings);
        //List 集合中的每个元素都添加对应的顺序索引，即支持索引。
        System.out.println(strings.get(0));


    }
}
