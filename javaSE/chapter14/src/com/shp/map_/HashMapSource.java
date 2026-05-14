package com.shp.map_;

public class HashMapSource {
    public static void main(String[] args) {
        /*
            Map接口实现类-HashMap

            ● HashMap底层机制及源码剖析
            HashMapSource.java
            ▷ 扩容机制 [和HashSet相同]

            1) HashMap底层维护了Node类型的数组table，默认为null
            2) 当创建对象时，将加载因子(load factor)初始化为0.75。
            3) 当添加key-val时，通过key的哈希值得到在table的索引。然后判断该索引处是否有元素
               如果没有元素直接添加。如果该索引处有元素，继续判断该元素的key是否和准备加入的
               key相等，如果相等，则直接替换val；如果不相等需要判断是树结构还是链表结构，做出
               相应处理。如果添加时发现容量不够，则需要扩容。
            4) 第1次添加，则需要扩容table容量为16，临界值(threshold)为12.
            5) 以后再扩容，则需要扩容table容量为原来的2倍，临界值为原来的2倍,即24,依次类推.
            6) 在java8中,如果一条链表的元素个数超过 TREEIFY_THRESHOLD(默认是8), 并且
               table的大小 >= MIN_TREEIFY_CAPACITY(默认64),就会进行树化(红黑树)
      * */
    }
}
