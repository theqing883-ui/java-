package com.shp.map_;

import java.util.*;

/*
以下是提取的文字内容：

### 左侧内容
韩顺平教育
Map接口和常用方法
● Map接口遍历方法
▷ Map遍历方式案例演示
MapFor.java
● 1) containsKey:查找键是否存在
2) keySet:获取所有的键
3) entrySet:获取所有关系
4) values:获取所有的值

* */

/*
HashMap内部有一个Node类（HashMap$Node），它实现了Map.Entry接口，所以每个Node对象就是一个键值对。

HashMap提供了三个集合视图：EntrySet、KeySet和Values。

EntrySet是存储Map.Entry（实际上是HashMap$Node）的集合，它实现了Set接口。

KeySet是存储key的集合，它实现了Set接口。

Values是存储value的集合，它实现了Collection接口。
* */

public class MapFor01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //1.先取出key,再通过key取出对应的Value
        Set keyset = map.keySet();
        //增强for
        for (Object key : keyset) {//取出key
            Object value = map.get(key);//取出value
            System.out.println(key + ":" + value);
        }
        //迭代器
        System.out.println("============");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }

        //直接取出所有value
        System.out.println("++++++++++++++++");
        Collection values = map.values();
        System.out.println(values);

        //通过EntrySet来获取key-value
        System.out.println("++++++++++++++++");
        Set entrySet = map.entrySet();//HashMap<EntrySet<Map.Entry<keyset,values>>>
        for (Object entry : entrySet) {
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey() + ":" + entry1.getValue());
        }
    }
}
