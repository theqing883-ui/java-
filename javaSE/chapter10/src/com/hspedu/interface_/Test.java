package com.hspedu.interface_;
/*当父类和子类定义了同样的一个变量x时，如果建立一个编译类型为父类，运行类型为子类的
* 对象，通过这个对象访问这个变量，访问的是父类的x,不是子类的x*/
public class Test {
    public static void main(String[] args) {
        vv v = new rr();
        System.out.println((new rr()).x);
        System.out.println(v.x);

    }
}

class vv {
    public int x = 1;
}

class rr extends vv {
//   public  int x = 2;
}