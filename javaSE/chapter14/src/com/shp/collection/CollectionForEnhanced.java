package com.shp.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionForEnhanced {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(new Book("三国演员"));
        collection.add(new Book("水府传"));
        collection.add(new Book("黑龙门"));

        //底层依旧是iterator
        for (Object book : collection) {
            System.out.println(book);
        }
        //底层是传统for()
        int[] a = {1,2,2,3};
        for(int i:a){
            System.out.println(i);
        }

    }
}
