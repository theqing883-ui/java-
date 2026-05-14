package com.hspedu.enum_;

/*
自定义类实现枚举 - 应用案例
不需要提供 setXxx 方法，因为枚举对象值通常为只读
对枚举对象 / 属性使用 final + static 共同修饰，实现底层优化
枚举对象名通常使用全部大写，常量的命名规范
枚举对象根据需要，也可以有多个属性 //Enumeration02.java
* */

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season1.AUTUMN);
        System.out.println(Season1.SPRING);
    }
}

//自定义枚举
/*
 * 1.构造器私有化，防止用户创建
 * 2.去掉setXXX()，相关方法，仿真用户修改属性
 * 3.在该类内部，直接创建固定的对象
 * 4.静态属性使用时会导致类加载，最好加final修饰符
 *  public final static
 * */
class Season1 {
    //定义了四个固定的对象
    public final static Season1 SPRING = new Season1("Spring", "生机勃勃");
    public final static Season1 SUMMER = new Season1("Summer", "阳光明媚");
    public final static Season1 AUTUMN = new Season1("Autumn", "硕果累累");
    public final static Season1 WINTER = new Season1("Winter", "白雪皑皑");
    private String name;
    private String desc;

    private Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
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
