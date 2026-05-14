package com.hspedu.poly_.Object_;
/*
1. 方法作用
当对象被 回收 时，系统会自动调用该对象的finalize方法；子类可以重写此方法，用于执行释放资源的操作（如资源清理等）。
2. 调用时机
当某个对象没有任何引用时，JVM 会将其判定为 “垃圾对象”，随后通过垃圾回收机制销毁该对象；在销毁对象前，会先调用其finalize方法。
3. 垃圾回收机制的触发
默认由系统自动决定触发时机；
也可以通过System.gc()主动触发垃圾回收机制；
测试案例示例：Car [name]
4.实际开发中几乎不会用
**/
public class Finalize {
    public static void main(String[] args) {
        Car bmw = new Car("宝马");
        bmw = null; //对象被销毁，空间等待回收
        System.gc();// 主动调用垃圾回收器
        // 这时上面的对象没有任何引用了，成了一个垃圾对象
        // 垃圾回收器就会销毁该对象，即释放空间，在释放空间前会调用finalize
        // 程序员就可以在里面finalize,在写自己的业务逻辑代码(如释放资源：
        // 数据库连接、或打开文件)
        // 如果程序员不重写finalize方法，那么就会调用Object类的finalize方法
        // 即默认处理
        System.out.println("程序退出");

    }
}
class Car{
    private String name;
    public Car(String name) {
        this.name = name;
    }
    //重写finalize

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁了汽车" + name);
        System.out.println("释放了某些资源~~~");
    }
}