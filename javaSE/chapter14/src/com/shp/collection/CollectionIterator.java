package com.shp.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(new Book("三国演员"));
        collection.add(new Book("水府传"));
        collection.add(new Book("黑龙门"));

//        System.out.println(collection);
        //利用itertor
        /*
        1.得到集合的迭代器
        2.while(iterator.hasNext())遍历
        3.iterator.hasNext()判断集合下一个元素是不是空的
        4.itit 快捷键 查找 ctrl + j
         while (iterator.hasNext()) {
            Object next =  iterator.next();
         5.当退出while循环后，这是iterator指向了最后一个元素
         6.如果需要再次遍历，则需要重置迭代器
            iterator = collection.iterator()
        * */
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            //返回的数据为Object类型
            Object o = iterator.next();
            System.out.println(o);
        }

    }

}

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
