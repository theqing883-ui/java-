package com.shp.list_;

import java.util.ArrayList;
import java.util.List;

/*
List 集合里添加了一些根据索引来操作集合元素的方法
boolean add(int index, Object ele)：在 index 位置插入 ele 元素
boolean addAll(int index, Collection eles)：从 index 位置开始将 eles 中的所有元素添加进来
Object get(int index)：获取指定 index 位置的元素
int indexOf(Object obj)：返回 obj 在集合中首次出现的位置
int lastIndexOf(Object obj)：返回 obj 在当前集合中末次出现的位置
Object remove(int index)：移除指定 index 位置的元素，并返回此元素
Object set(int index, Object ele)：设置指定 index 位置的元素为 ele，相当于替换
List subList(int fromIndex, int toIndex)：返回从 fromIndex 到 toIndex 位置的子集合[fromIndex,toIndex)
* */
public class ListMethod {
    public static void main(String[] args) {
        //演示
        List list = new ArrayList();
        //插入
        list.add(100);
        list.add(3);
        list.add(4);
        list.add(1,"xxq");
        System.out.println(list);

//删除
        list.remove(1);//默认按索引删除
        list.remove(new Integer(100));//按指定元素删除
        System.out.println(list);

//修改
       list.set(1, "杨过");//相当于替换
        System.out.println(list);
    }
}
