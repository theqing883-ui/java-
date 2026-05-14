package com.hspedu.modifier;
// 一个项目要运行至少要有一个main方法，通常也只有一个，但是可以不止一个
// 包含main方法的类，通常叫主类

/*java 提供四种访问控制修饰符号，用于控制方法和属性(成员变量)的访问权限（范围）:
1) 公开级别:用public 修饰,对外公开
2) 受保护级别:用protected修饰,对子类和同一个包中的类公开
3) 默认级别:没有修饰符号,向同一个包的类公开.
4) 私有级别:用private修饰,只有类本身可以访问,不对外公开.
5. 访问修饰符可以修饰类的属性、方法以及类
6. 只有 默认 和 public 可以修饰类
7. 成员方法的访问规则与属性一样
*/


public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.print();
        B b = new B();
        b.say();
    }
}
