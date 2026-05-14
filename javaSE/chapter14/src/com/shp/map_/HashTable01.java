package com.shp.map_;

import java.util.Hashtable;

/*
### 标题
顺平教育
Map接口实现类-Hashtable


### HashTable的基本介绍
1) 存放的元素是键值对：即 K-V
2) hashtable的键和值都不能为null，否则会抛出NullPointerException
3) hashTable 使用方法基本上和HashMap一样
4) hashTable 是线程安全的(synchronized)，hashMap 是线程不安全的
5) 简单看下底层结构



* */
public class HashTable01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Hashtable table = new Hashtable();//ok
        table.put("john", 100); //ok
//        table.put(null, 100); //异常
//        table.put("john", null);//异常
        table.put("lucy", 100);//ok
        table.put("lic", 100);//ok
        table.put("lic", 88);//替换
        for (int i = 0; i < 12; i++) {
            table.put(i, i);
        }
        System.out.println(table);

    }
}
