package com.hsp.array_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void bubbleSort(Book[] books, Comparator c) {
        Book temp;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (c.compare(books[j].getPrice(), books[j + 1].getPrice()) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = (temp);
                }
            }
        }
    }

    public static void bubbleSort01(Book[] books, Comparator c) {
        Book temp;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (c.compare(books[j].getName().length(), books[j + 1].getName().length()) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = (temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book(100, "红楼梦");
        books[1] = new Book(90, "金瓶梅新");
        books[2] = new Book(5, "青年文摘20年");
        books[3] = new Book(500, "java从入门到放弃~");

        bubbleSort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;//从大到小
//                return i1 - i2;//从小到大

            }
        });
        for (Book b : books) {
            System.out.println(b.toString());
        }
        System.out.println("================");
        bubbleSort01(books, new Comparator() {
            //这里是对Book数组排序，因此o1和o2就是Book对象
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;//从大到小
//                return i1 - i2;//从小到大

            }
        });
        for (Book b : books) {
            System.out.println(b.toString());
        }


        Arrays.sort(books, new Comparator() {
            //这里是对Book数组排序，因此o1和o2就是Book对象
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double d1 = b1.getPrice() - b2.getPrice();
                if (d1 < 0) {
                    return 1;
                }else if (d1 > 0) {
                    return -1;
                }else{
                    return 0;
                }

            }
        });
        System.out.println(Arrays.toString(books));


    }
}

class Book {
    private String name;
    private int price;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
