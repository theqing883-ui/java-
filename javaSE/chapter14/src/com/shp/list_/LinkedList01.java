package com.shp.list_;

public class LinkedList01 {
    public static void main(String[] args) {
        /*
        # LinkedList底层结构
        ● LinkedList的全面说明
        1) LinkedList实现了双向链表和双端队列特点
        2) 可以添加任意元素(元素可以重复)，包括null
        3) 线程不安全，没有实现同步

        * */
        /*
        ● LinkedList 的底层操作机制
        LinkedList 底层维护了一个双向链表。
        LinkedList 中维护了两个属性 first 和 last 分别指向首节点和尾节点
        每个节点（Node 对象），里面又维护了 prev、next、item 三个属性，其中通过 prev 指向前一个，通过 next 指向后一个，节点通过这实现双向链表。
        所以 LinkedList 的元素的添加和删除，不是通过数组实现的，相对来说效率较高。
        * */

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("老韩");
        //连接三个结点，形成双向链表
        //jack-> tom-> hsp
        jack.next = tom;
        tom.next = hsp;
        //hsp-> tom-> jack
        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack;//让 first 引用指向 jack,就是双向链表的头结点
        Node last = hsp; //让 last 引用指向 hsp,就是双向链表的尾结点

        //从头到尾
        while(true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //从尾到头
        while(true){
            if(last == null){
                break;
            }
            System.out.println(last);
            last = last.pre;
        }
        //添加
        Node fei = new Node("张飞");
        tom.next = fei;
        fei.pre = tom;
        fei.next = hsp;
        hsp.pre = fei;
        System.out.println("==========");

        first = jack; //重置
        while(true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

//定义一个Node类，Node对象表示双向链表的一个结点
class Node {
    public Object item;//真正存放数据
    public Node next;//指向后一个结点
    public Node pre;//指向前一个结点

    public Node(Object name) {
        this.item = name;
    }

    public String toString() {
        return "Node name = " + item;
    }
}

