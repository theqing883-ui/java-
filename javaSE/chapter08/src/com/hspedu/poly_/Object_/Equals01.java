package com.hspedu.poly_.Object_;

/*
  ==介绍
1. == 是一个比较运算符
2. ==：既可以判断基本类型，又可以判断引用类型
3. ==：如果判断基本类型，判断的是值是否相等。示例：int i=10; double d=10.0;
4. ==：如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象【案例说明】
* */

/*
equals 方法
  源码：public boolean equals(Object anObject)
1. equals：是 Object 类中的方法，只能判断引用类型
2. 默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容(属性的值)是否相等。
    比如 Integer,String【看看 String 和 Integer 的 equals 源代码】
* */

/*
以下是==和equals的区别提取：
名称  	概念	                             用于基本数据类型	                用于引用类型
==	    比较运算符	                      可以，判断值是否相等	            可以，判断两个对象是否相等
equals	Object 类的方法（Java类都可使用）	    不可以	                    可以，默认判断对象是否相等；
                                                                        子类常重写，比较对象属性
                                                                        （如 String、Integer）

* */

public class Equals01 {

    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        A d = new B();
        B e = new B();
        C f = new C();
        /*
            判断a,c是否指向同一个对象
            并且当两者的类是同一个，或者两者的类有继承关系时才能比较
        * */
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);

        int n1 = 1;
        int n2 = 1;
        System.out.println(n1 == n2);



//        System.out.println(a == f);//a和f的类不是同一个也没有继承关系，因此不能比较


//        Ctrl + B 查看源码
        "Hello".equals("abs");
        System.out.println(a.equals(b));

        Integer i1 = new Integer(1000);
        Integer i2 = new Integer(1000);
        System.out.println(i1 == i2);//false
        /*默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容(值)是否相等。
        比如 Integer,String【看看 String 和 Integer 的 equals 源代码】*/
        System.out.println(i2.equals(i1));//true

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true
    }
}
class A{

}
class B extends A{}
class C {}
