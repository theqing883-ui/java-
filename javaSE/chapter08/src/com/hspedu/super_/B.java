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


*/
public class B extends A {
    public B() {
//        super();
//        super("jake");
        super("jake", 10);

    }
    public void cal(){
        System.out.println("B类的cal()被调用");
    }
    public void sum(){
        System.out.println("B类的sum()方法");
        /*
        * 希望调用父类的方法cal()
        * 因为子类没有方法cal()，因此有三种方法可以调用
        *  super.cal(),this.cal().cal
        * 后两种方法，就类似cal()是B类的方法
        * */
        cal();
        this.cal();
        /*
        *   this.cal();、 cal(); 先找本类，如果有则调用，如果没有就找父类
        *  如果父类有且可以调用【不可调用就报错】，就调用，
        *  如果没有就继续向上找...直到Object
        * */
        super.cal();
        /*
        * super.cal();直接找父类，如果父类有且可以调用【不可调用就报错】，就调用，
        * 如果没有就继续向上找...直到Object
        * */


    }
    public void f() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }

    public void g() {
        super.test100();
        super.test200();
        super.test300();
//        super.test400(); // 无法访问私有方法
    }
}
