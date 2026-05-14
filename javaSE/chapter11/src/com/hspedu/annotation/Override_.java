package com.hspedu.annotation;
/*
1) 注解(Annotation)也被称为元数据(Metadata)，用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。
2) 和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息。
3) 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替java EE旧版中所遗留的繁冗代码和XML配置等。


基本的 Annotation应用案例
▶ @Override 使用说明
1. @Override 表示指定重写父类的方法（从编译层面验证），如果父类没有fly方法，则会报错
2. 如果不写@Override 注解，而父类仍有public void fly()，仍然构成重写
3. @Override 只能修饰方法，不能修饰其它类，包，属性等等
4. 查看@Override注解源码为 @Target(ElementType.METHOD),说明只能修饰方法
5. @Target 是修饰注解的注解，称为元注解，记住这个概念


* */
public class Override_ {
    public static void main(String[] args) {

    }
}

class Father {
    public void fly() {
        System.out.println("Father fly....");
    }
}
class Son extends Father {
    /*
    * 1.@Override 表示下面的方法是重写父类的
    * 2.如果不写@Override，下面的方法也是重写父类的
    * 3.如果写了@Override注解，编译器就会检查该方法是否真的重写了父类的方法
    *   如果重写了，就编译通过，否则编译错误【语法校验】
    * 4.@Target 的定义: @interface表示一个注解类，不是接口，JDK5.0后加入
    *   @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override {
        }
    * */
    @Override
    public void fly() {
        System.out.println("Son fly....");
    }
}