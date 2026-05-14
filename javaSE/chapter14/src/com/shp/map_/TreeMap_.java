package com.shp.map_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {


//        TreeMap treeMap = new TreeMap();//无序
        TreeMap treeMap = new TreeMap(new Comparator() {//排序
            @Override

            public int compare(Object o1, Object o2) {//   cmp = cpr.compare(key, t.key);
                return ((String) o1).length() - ((String) o2).length();
            }
        });

        treeMap.put("A", 1);
        treeMap.put("B", 2);
        treeMap.put("C", 3);
        treeMap.put("Smith", 8);
        treeMap.put("Dasada", 4);
        treeMap.put("Apurou", 5);
        System.out.println(treeMap);

    }
}
