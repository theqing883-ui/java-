package com.hspedu.single_;

/*
步骤 懒汉式
1.构造器私有化
2.定义一个静态属性的对象
3.提供一个public的static方法，返回一个Cat对象
4.只有当用法使用getInstance方法时,才创建对象，
    再次调用时不会再创建，返回第一次创建的对象
* */

/*
饿汉式 VS 懒汉式
1.二者最主要的区别在于创建对象的时机不同：饿汉式是在类加载就创建了对象实例，而懒汉式是在使用时才创建。
2.饿汉式不存在线程安全问题，懒汉式存在线程安全问题。（后面学习线程后，会完善一把）
3.饿汉式存在浪费资源的可能。因为如果程序员一个对象实例都没有使用，那么饿汉式创建的对象就浪费了，懒汉式是使用时才创建，就不存在这个问题。
4.在我们 javaSE 标准类中，java.lang.Runtime 就是经典的单例模式。
* */

public class SingleTone02 {
    public static void main(String[] args) {
        System.out.println(Cat.n1);
        System.out.println("---------现在还没有使用对象----------\n");
        System.out.println("---------第一次使用对象----------");
        System.out.println(Cat.getInstance());
        System.out.println("---------第一次使用对象----------");
        System.out.println(Cat.getInstance());
//        Runtime
    }
}

//希望在程序运行过程中，只能创建一个对象
class Cat {
    public static int n1 = 99;
    private static Cat cat;
    private String name;

//    步骤
//    1.构造器私有化
//    2.定义一个静态属性的对象
//    3.提供一个public的static方法，返回一个Cat对象
//    4.只有当用法使用getInstance方法时,才创建对象，再次调用时不会再创建，返回第一次创建的对象
    private Cat(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {//在调用的时候，如果发现cat还未创建，就先创建再返回
            cat = new Cat("大蹦猪");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
