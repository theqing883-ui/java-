package com.hspedu.super_;

/*子类通过super访问父类
注意：super关键字只能在子类中使用，不能在无关的类或其他上下文中使用。
1. 在同一个包里：
    1) 子类继承了所有的属性和方法，父类中非私有的属性和方法可以在子类中直接访问
        super. 方法名 (参数列表)
    2) 私有(private)属性和方法不能在子类直接访问，要通过父类提供的公共(public)
方法去访问
 2.在不同的包里：
        1) 子类只能访问父类的 public 和 protected 修饰的属性和方法

访问修饰符	同类	   同包	  子类(同包)	 子类(不同包)    	不同包非子类
public	    ✓	    ✓	    ✓	         ✓	         ✓
protected	✓	    ✓	    ✓	         ✓	         ❌
默认	        ✓	    ✓	    ✓	         ❌   	     ❌
private 	✓	    ❌	    ❌	         ❌	         ❌


3.访问父类的属性，但不能访问父类的 private 属性 [案例] super. 属性名；
4.访问父类的构造器 (这点前面用过)：super (参数列表);
  只能放在构造器的第一句，只能出现一句！不能和this()一起出现在同一个构造器
5. 构造器的调用 只能用在构造器中，不能用在普通方法中，super()和this()都是如此
6. 在子类中希望调用父类的某个方法，如果子类没有这个方法，则有三种方法可以调用
    super.cal(),this.cal().cal
        *   this.cal();、 cal(); 先找本类，如果有则调用，如果没有就找父类
        *  如果父类有且可以调用【不可调用就报错】，就调用，
        *  如果没有就继续向上找...直到Object
7.如果子类和父类拥有同一个方法，如果要调用子类的该方法就使用 cal()、this.cal()
  如果要调用父类的该方法则使用 super()
8. super 的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用 super
   去访问爷爷类的成员；如果多个基类 (上级类) 中都有同名的成员，使用 super
   访问遵循就近原则。A->B->C，当然也需要遵守访问权限的相关规则
9. Java 严格禁止循环继承，这是由语言设计决定的：
    ✅ 允许：单继承链 A → B → C
    ❌ 禁止：任何形式的循环继承 A → B → A

10.this 和 super 的区别对比
No.	区别点	                        this                                          super
1	访问属性         访问本类中的属性，如果本类没有此属性则从父类中继续查找	        从父类开始查找属性
2	调用方法	        访问本类中的方法，如果本类没有此方法则从父类继续查找	            从父类开始查找方法
3	调用构造器	    调用本类构造器，必须放在构造器的首行	                    调用父类构造器，必须放在子类构造器的首行
4	特殊	                         表示当前对象	                                 子类中访问父类对象




*/

public class A {
    //    创建四个不同修饰符的成员变量
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public A() {}

    public A(String name) {}

    public A(String name, int n2) {}

    public void cal(){
        System.out.println("A类的cal方法");
    }


    public void test100() {
    }

    protected void test200() {
    }

    void test300() {
    }

    private void test400() {
    }
}
