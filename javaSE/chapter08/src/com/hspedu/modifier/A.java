package com.hspedu.modifier;

/*java 提供四种访问控制修饰符号，用于控制方法和属性(成员变量)的访问权限（范围）:
1) 公开级别:用public 修饰,对外公开
2) 受保护级别:用protected修饰,对子类和同一个包中的类公开
3) 默认级别:没有修饰符号,向同一个包的类公开.
4) 私有级别:用private修饰,只有类本身可以访问,不对外公开.
5.访问修饰符可以修饰类的属性、方法以及类
6.只有 默认 和 public 可以修饰类
7.成员方法的访问规则与属性一样
*/
// java创建一个A类再在这个文件带入B类，A,B在同一个包，之间拥有包级访问权限
/*
访问修饰符	同类	   同包	  子类(同包)	 子类(不同包)    	不同包非子类
public	    ✓	    ✓	    ✓	         ✓	         ✓
protected	✓	    ✓	    ✓	         ✓	         ❌
默认	        ✓	    ✓	    ✓	         ❌   	     ❌
private 	✓	    ❌	    ❌	         ❌	         ❌

说明：子类可以访问父类的protected成员，父类不能访问子类protected成员
如果有父类能访问子类 protected 成员的情况，那纯粹是因为它们恰好在同一个包

默认 也同上说明
* */
public class A {
//    创建四个不同修饰符的成员变量
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;
    public void print() {
        System.out.println("B类被调用");
        //        该方法可以访问4个成员变量
        System.out.println("n1 = " + n1 + " n2 = " + n2 + " n3 = "+
                n3 + " n4 = "+ n4);
    }
   protected void cut1() {

    }
    void cut2() {

    }
    private void cut3() {

    }
    public void cut4() {
        // 可以直接调用同一个类中的其他方法
        cut1();
        cut2();
        cut3();
        print();
    }
}




//6.只有 默认 和 public 可以修饰类
class Tiger {

}
