package com.hspedu.InnerClass;
/*一个类的内部又完整的嵌套了另一个类结构。
被嵌套的类称为内部类 (inner class)，
嵌套其他类的类称为外部类 (outer class)。
是我们类的第五大成员
【思考：类的五大成员是哪些？[属性、方法、构造器、代码块、内部类]】，
内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系*/

/*
内部类的分类
1.定义在外部类 局部位置 上（比如方法内）：
    1)局部内部类（有类名）
    2)匿名内部类（没有类名，重点！！！！！！！）
2.定义在外部类的 成员位置 上：
    1)成员内部类（没用 static 修饰）
    2)静态内部类（使用 static 修饰）

说明：局部内部类只能放在代码块或者方法体中，
     匿名内部类通常放在代码块或者方法体中，也可以放在类的成员位置
     成员内部类和静态内部类都放在类的成员位置，但是静态内部类有static修饰
* */

public class InnerClass01 {
    public static void main(String[] args) {

    }
}

class Outer {//外部类
    //属性
    private int x;

    //代码块
    {

    }

    //构造器
    public Outer(int x) {
        this.x = x;
    }

    //方法
    public void print() {
    }

    //内部类
    class Inner {
        private int y;
    }
}

//外部其他类
class Other {

}
