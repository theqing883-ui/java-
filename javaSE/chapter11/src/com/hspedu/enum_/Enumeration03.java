package com.hspedu.enum_;

enum Season2 {
    //定义了四个固定的对象
//    public final static Season1 SPRING = new Season1("Spring", "生机勃勃");
//    public final static Season1 SUMMER = new Season1("Summer", "阳光明媚");
//    public final static Season1 AUTUMN = new Season1("Autumn", "硕果累累");
//    public final static Season1 WINTER = new Season1("Winter", "白雪皑皑");
    SPRING("Spring", "生机勃勃"),
    SUMMER("Summer", "阳光明媚"),
    AUTUMN("Autumn", "硕果累累"),
    WINTER("Winter", "白雪皑皑"),


    SPRING1;
    /*
    // 这是编译后的伪代码
       final class Season extends java.lang.Enum<Season> {

    // 1. 编译器生成的构造器，不再是无参的了！
    // 它强制接收 name 和 ordinal
    private Season(String name, int ordinal) {
        // 2. 这里必须先调用父类 Enum 的构造器
        super(name, ordinal);
    }

    // 3. 静态初始化创建对象
    public static final Season SPRING1 = new Season("SPRING1", 0);
}
    * */



    private String name;
    private String desc;

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private Season2() {

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

//使用关键字 enum 实现枚举类
/*
 * 1.使用关键字enum 替代 class
 * 2.创建对象方式：常量名(实参列表) 但是底层都是  public static final 修饰
 * 3.如果有多个常量对象，使用逗号间隔：常量名1(实参列表),常量名2(实参列表);(注意最后以分号结尾)
 * 4.注意：使用关键字 enum 实现枚举类时，必须将常量对象的创建写在枚举类的最前面
 * 5.如果使用的是无参构造器 创建 对象枚举，则实参列表和小括号都可以省略
 *  常量名1， 常量名2;
 * 6.当我们使用 enum 关键字开发一个枚举类时，默认会继承 Enum 类，
 * 【继承以后创建子类对象就会调用父类构造器，Enum的构造器为： private Season(String name, int ordinal){。。。}】
 *  而且是一个 final 类 [如何证明，老师使用 javap 工具来演示]
 * */

/*
enum实现接口

1) 使用enum关键字后，就不能再继承其它类了，因为enum会隐式继承Enum，而java是单继承机制。
2) 枚举类和普通类一样，可以实现接口，如下形式。
enum 类名 implements 接口1，接口2{}

* */

/* javap 反编译结果
final class com.hspedu.enum_.Season2 extends java.lang.Enum<com.hspedu.enum_.Season2> {
  public static final com.hspedu.enum_.Season2 SPRING;
  public static final com.hspedu.enum_.Season2 SUMMER;
  public static final com.hspedu.enum_.Season2 AUTUMN;
  public static final com.hspedu.enum_.Season2 WINTER;
  public static com.hspedu.enum_.Season2[] values();
  public static com.hspedu.enum_.Season2 valueOf(java.lang.String);
  public java.lang.String getName();
  public java.lang.String getDesc();
  public java.lang.String toString();
  static {};
* */

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}




