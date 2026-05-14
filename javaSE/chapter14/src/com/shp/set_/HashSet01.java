package com.shp.set_;

import java.util.HashSet;
import java.util.Objects;

/*
# Set接口实现类-HashSet
● HashSet的全面说明
HashSet.java
1) HashSet实现了Set接口
2) HashSet实际上是HashMap，看下列源码.

3) 可以存放null值，但是只能有一个null
4) HashSet不保证元素是有序的,取决于hash后，再确定索引的结果.
5) 不能有重复元素/对象,在前面Set 接口使用已经讲过

* */
public class HashSet01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HashSet set = new HashSet();
        //说明
        //1. 在执行add方法后，会返回一个boolean值
        //2. 如果添加成功，返回 true, 否则返回false
        //3. 可以通过 remove 指定删除哪个对象
        System.out.println(set.add("john"));//T
        System.out.println(set.add("lucy"));//T
        System.out.println(set.add("john"));//F
        System.out.println(set.add("jack"));//T
        System.out.println(set.add("Rose"));//T

        set.remove("john");
        System.out.println(set);

        set = new HashSet();
        System.out.println("set=" + set);//0
        //4 Hashset 不能添加相同的元素/数据?
        set.add("lucy");//添加成功
        set.add("lucy");//加入不了
        set.add(new Dog("tom"));//OK
        set.add(new Dog("tom"));//Ok
        // 因为这里equals和hashCode未重写
        //如果也要它添加不了需要重写hashcode，根据内容计算hashcode，并且重写equals比较内容
        System.out.println("set=" + set);
        System.out.println(new Dog("tom").equals(new Dog("tom")));
        //在加深一下. 非常经典的面试题
        set.add(new String("hsp"));//ok
        set.add(new String("hsp"));//加入不了.
        // String重写了hashCode返回的hashCode值一样，并且equals比较的是内容
        // String的hashcode是基于内容value()计算的
        System.out.println("set=" + set);

    }
}

class Dog { //定义了 Dog 类
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\''
                + '}';
    }
    @Override
    public boolean equals(Object obj) {
        // 1. 如果是同一个对象，返回true
        if (this == obj) {
            return true;
        }
        // 2. 如果obj为null或者类型不匹配，返回false,getClass()返回运行类型
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
        if(!(obj instanceof Dog)) {
            return false;
        }
        // 3. 类型转换
        Dog other = (Dog) obj;
        // 4. 比较name字段
        // 注意：name可能为null，需要安全比较
        if (name == null) {
            return other.name == null;
        } else {
//            return Objects.equals(this.name,other.name);
            return this.name.equals(other.name);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

