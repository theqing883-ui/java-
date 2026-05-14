package com.hspedu.extend_;

/*
1. 在同一个包里：
    1) 子类继承了所有的属性和方法，父类中非私有的属性和方法可以在子类中直接访问
    2) 私有(private)属性和方法不能在子类直接访问，要通过父类提供的公共(public)
      方法去访问
 2.在不同的包里：
     1) 子类只能访问父类的 public 和 protected 修饰的属性和方法

访问修饰符	同类	   同包	  子类(同包)	 子类(不同包)    	不同包非子类
public	    ✓	    ✓	    ✓	         ✓	         ✓
protected	✓	    ✓	    ✓	         ✓	         ❌
默认	        ✓	    ✓	    ✓	         ❌   	     ❌
private 	✓	    ❌	    ❌	         ❌	         ❌

3. 在创建子类对象时，子类必须调用父类的构造器，完成父类的初始化
4. 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器，
  如果父类没有提供无参构造器，则必须在子类的构造器中用 super 去指定使用父类的哪
  个构造器完成对父类的初始化工作，否则，编译不会通过【举例说明】
  会先执行父类构造器，再执行子类构造器
5.super 在使用时，必须放在构造器第一行(super只能在构造器中使用)
6.super () 和 this () 都只能放在构造器第一行，
   因此这两个方法不能共存在一个构造器
7.java 所有类都是 Object 类的子类，Object 是所有类的基类。
  [Ctrl + H可以看见类的继承关系]
8.父类构造器的调用不限于直接父类！将一直往上追溯直到 Object 类 (顶级父类)
9.子类最多只能继承一个父类 (指直接继承)，即 java 中是单继承机制。
    思考：如何让 A 类继承 B 类和 C 类？【 先让A继承B，再B继承C】
10.不能滥用继承，子类和父类之间必须满足 is-a 的逻辑关系
Person is a Music?
Person Music
Music extends Person（不合理）

Animal
Cat extents Animal（合理）
*/


public class ExtendsDetail {
    public static void main(String[] args) {
//      当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
        System.out.println("==第一个对象==");
        Sub sub = new Sub();//虽然这里只调用了子类的构造器，
        System.out.println("===第二个对象===");  // 但是父类的构造器无参构造器也会被默认执行
        Sub sub2 = new Sub("name");
        System.out.println("===第三个对象===");  // 但是父类的构造器无参构造器也会被默认执行
        Sub sub3 = new Sub("name",40);

//        sub.sayOK();
    }
}
