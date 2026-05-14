package com.hspedu.InnerClass;

import com.hspedu.abstract_.AA;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        //匿名内部类可以直接作为实参传入，当使用一次等时使用这种方式
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一副名画");
            }
        });
        System.out.println("=======");
        f1(new Picture());
    }
    //静态方法，形参为接口类型
    public static void f1(IL il){
        il.show();
    }
}
interface IL {
    void show();
}

//类-》实现IL=》硬编码
class Picture implements IL {
    @Override
    public void show() {
        System.out.println("这是一副名画");
    }
}