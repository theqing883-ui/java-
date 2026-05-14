package com.shp.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
# Set接口和常用方法
● Set接口基本介绍
1) 无序（添加和取出的顺序不一致），没有索引[后面演示]
2) 不允许重复元素，所以最多包含一个null
3) JDK API中Set接口的实现类有：

java.util
接口 Set<E>
类型参数：
    E - 此 set 维护的元素的类型
所有超级接口：
    Collection<E>, Iterable<E>
所有已知子接口：
    SortedSet<E>
所有已知实现类：
    ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet, HashSet, JobStateReasons, LinkedHashSet, TreeSet

* */
/*
# Set接口和常用方法
● Set接口的常用方法
和List接口一样, Set接口也是Collection的子接口, 因此, 常用方法和Collection接口一样.

● Set接口的遍历方式
同Collection的遍历方式一样, 因为Set接口是Collection接口的子接口。
1. 可以使用迭代器
2. 增强for
3. 不能使用索引的方式来获取.

* */
public class Set01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);//重复元素不再添加
        set.add(null);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();//输出顺序和输入不一样，但输出顺序固定
            System.out.println(obj);
        }

        for (Object o: set){
            System.out.println(o);
        }
    }
}
