package com.shp.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        /*
        1.集合主要是两组（单列集合、双列集合）
        2.Collection 接口有两个重要的字接口 List Set ,他们都是实现子类的单列集合
        3.Map 接口的实现子类 是双列集合，存放的是K-V
        * */
        //单列集合
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");//单列数据
        arrayList.add("tom");
        //双列集合
        HashMap hashMap = new HashMap();
        hashMap.put("NO1", "北京");//双列数据
        hashMap.put("NO2", "上海");
    }
}
