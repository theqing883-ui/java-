package com.hspedu.main_;
/*
深入理解 main 方法语法
1.main 方法的形式：public static void main(String[] args){}
2.访问权限：public Java 虚拟机需要调用类的 main () 方法，它们不在同一个包
    因此该方法的访问权限必须是 public。
3.修饰符：static Java 虚拟机在执行 main () 方法时不必创建对象，
    所以该方法必须是 static。
4.返回值：void该方法接收执行 java 命令时传递给所运行类的参数，无需返回值。
5.参数：String [] args用于接收 执行程序(执行.class文件) 时的参数
    执行.class文件（格式：java 类名 参数1 参数2 参数3），参数会保存在 args 数组中。
* */
/* E:\java_code\Main_(在dos里面)
E:\java_code>javac Main_.java

E:\java_code>java Main_

E:\java_code>java Main_ tom jake snith
第1个元素是tom
第2个元素是jake
第3个元素是snith

* */

/*
1.main 方法中成员的访问规则
    可直接调用的成员在 main () 方法中，能直接调用当前类的静态方法或静态属性。
2.不可直接访问的成员不能直接访问当前类的非静态成员，必须先创建该类的实例对象，
    再通过对象访问这些非静态成员。
* */
//本类中也可以创建本类的对象
public class Main01 {
    private static int y = 2;
    private int x = 1;

    public static void main(String[] args) {
        // public
       /* System.out.println(x);无法直接访问非静态变量
        aa();无法直接访问非静态方法 */
        System.out.println(new Main01().x);//创建对象后访问
        new Main01().aa();//本类中也可以创建本类的对象

        //可以直接访问静态变量和静态方法
        System.out.println(y);
        bb();
    }

    public static void bb() {
        System.out.println("222");
    }

    public void aa() {
        System.out.println("111");
    }
}
