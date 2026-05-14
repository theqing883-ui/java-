package com.shp.list_;

/*
# ArrayList 和 LinkedList比较
● ArrayList和LinkedList的比较

|          | 底层结构 | 增删的效率               | 改查的效率 |
|----------|---------|-----------------------|------------|
| ArrayList| 可变数组  | 较低（数组扩容）           | 较高      |
| LinkedList| 双向链表 | 较高（通过链表追加）       | 较低       |


如何选择ArrayList和LinkedList:
1) 如果我们改查的操作多，选择ArrayList
2) 如果我们增删的操作多，选择LinkedList
3) 一般来说，在程序中，80%-90%都是查询，因此大部分情况下会选择ArrayList
4) 在一个项目中，根据业务灵活选择，也可能这样，一个模块使用的是ArrayList，另外一个模块是LinkedList.

* */
import java.util.LinkedList;
@SuppressWarnings("ALL")
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
    }
}
