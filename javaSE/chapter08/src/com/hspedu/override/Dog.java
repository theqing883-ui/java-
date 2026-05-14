package com.hspedu.override;

/*
简单的说：方法覆盖 (重写) 就是子类有一个方法，
和父类的某个方法的名称、返回类型、参数一样，
那么我们就说子类的这个方法覆盖了父类的方法

1.子类的方法的参数、方法名称，要和父类方法的参数、方法名称完全一样。【演示】
2.子类方法的返回类型和父类方法返回类型一样，或者是父类返回类型的子类
   比如 父类 返回类型是 Object，子类方法返回类型是 String【演示】
   如果子类方法的返回类型是父类返回类型的父类，或者是与父类返回类型无关的类型，
   则会报错
   比如 父类 返回类型是 String，子类方法返回类型是 Object
   比如 父类 返回类型是 String，子类方法返回类型是 AAA【新创建的类】
3.父类方法被子类覆盖以后，在子类中依旧可以使用 super.xx() 调用
4.子类方法不能缩小父类方法的访问权限,否则会报错
    同时给出访问权限的优先级顺序：public > protected > 默认 > private
    对应的代码示例：
    java
    运行
    // 父类方法（访问权限为默认）
    void sayOk(){}

    // 子类方法（访问权限为public，未缩小父类权限）
    public void sayOk(){}
*/

public class Dog extends Animal {
    public void cry() {
        super.cry();
        System.out.println("小狗旺旺叫~~~~");
    }

    public String eat() {
        return null;
    }

    //   如果子类方法的返回类型是父类返回类型的父类，或者是与父类返回类型无关的类型，
//   则会报错
   /* public Object m1() {
        return null;
    }

    public AAA m2() {
        return null;

    }*/

    class AAA {}
}
