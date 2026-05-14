package com.shp.set_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    @SuppressWarnings({"ALL"})
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();//无序  默认compareTo去重
//        TreeSet ts = new TreeSet(new Comparator() {//排序且去重
//            @Override//制定排序规则
//            public int compare(Object o1, Object o2) {
////                return ((String)o1).compareTo((String)o2);//从小到大
//                return ((String)o1).length() - ((String)o2).length();
//                //返回第一个不同字符的差值 或 长度差
//            }
//        });
        //元素不可重复
        ts.add("abcd");
        ts.add("adc");
        ts.add("adc");
        ts.add("cd");
        ts.add("g");
        ts.add("h");//无法加入 return ((String)o1).length() - ((String)o2).length();
        System.out.println("ts = " + ts);
//        ts.add(new Person());//ClassCastException
        /*
        分析源码
        add 方法，因为 TreeSet() 构造器没有传入Comparator接口的匿名内部类
        所以在底层 Comparable<? super K> k = (Comparable<? super K>) key;
        即 把 Perosn转成 Comparable类型
        * */


        //未排序前是无序的，但可排序处理
        /*
          TreeSet ts = new TreeSet(new Comparator() {
            @Override//制定排序规则
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);//从小到大
                //返回第一个不同字符的差值 或 长度差
            }
        });
        * */

    }

}
class Person{ }
