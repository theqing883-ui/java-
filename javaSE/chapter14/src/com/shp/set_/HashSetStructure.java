package com.shp.set_;



public class HashSetStructure {
    public static void main(String[] args) {
        Node[] table = new Node[10];

        Node jone = new Node("Jone", null);
        Node Jake = new Node("jake", null);
        Node Rose = new Node("rose", null);

        table[2] = jone;
        jone.next = Jake;
        Jake.next = Rose;
        System.out.println(table[2]);

        String s = new String("1212");
        String s1 = new String("1212");

        Dog dog = new Dog("12");
    }
}

class Node {
    public String name;
    public Node next;

    public Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
