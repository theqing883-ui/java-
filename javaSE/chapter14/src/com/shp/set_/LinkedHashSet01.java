package com.shp.set_;
/*
# Set接口实现类-LinkedHashSet
● LinkedHashSet的全面说明
1) LinkedHashSet 是 HashSet 的子类
2) LinkedHashSet 底层是一个 LinkedHashMap，底层维护了一个 数组+双向链表
3) LinkedHashSet 根据元素的 hashCode 值来决定元素的存储位置，同时使用链表维护元素的次序(图)，这使得元素看起来是以插入顺序保存的。
4) LinkedHashSet 不允许添加重复元素

* */

import java.util.LinkedHashSet;
import java.util.Set;

/*

说明
1) 在LinkedHashSet中维护了一个hash表和双向链表（LinkedHashSet 有 head 和 tail）
2) 每一个节点有 before 和 after 属性，这样可以形成双向链表
3) 在添加一个元素时，先求hash值，在求索引，确定该元素在table的位置，然后将添加的元素加入到双向链表(如果已存在，不添加[原则和hashset一样])
4) 这样的话，我们遍历LinkedHashSet也能确保插入顺序和遍历顺序一致

* */
@SuppressWarnings({"all"})
public class LinkedHashSet01 {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(123);
        set.add("HSP");
        System.out.println(set.size());
        System.out.println(set);//有序输出
    }
}
