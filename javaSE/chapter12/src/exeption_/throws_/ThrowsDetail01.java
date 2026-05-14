package exeption_.throws_;

/*
1. 对于编译异常，程序必须处理，比如try-cath或者throws【编译异常必须显示处理】
2. 对于运行异常，程序没有处理，默认就是throws的方式处理
2. 对于运行异常，程序没有处理，默认就是throws的方式处理
3. 子类重写父类的方法时，对抛出异常的规定：
   【子类重写方法所抛出的异常，只能与父类被重写方法抛出异常一样，
   或者是父类被重写方法抛出异常的子类】
4.在异常处理过程中，如果有 try-catch ，就可不必有throws
* */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail01 {
    public static void main(String[] args) {
        f2();
    }

    public static void f2() {
        /*
        1. 对于编译异常，程序必须处理，比如try-cath或者throws
        2. 对于运行异常，程序没有处理，默认就是throws的方式处理
        3. 子类重写父类的方法时，对抛出异常的规定：
        【子类重写方法所抛出的异常，只能与父类被重写方法抛出异常一样，
           或者是父类被重写方法抛出异常的子类】
         4.在异常处理过程中，如果有 try-catch ，就可不必有throws
        * */
        int a = 1;
        int b = 0;
        int res = a / b;
    }

    public static void f1() {
        /*这里报错的原因是未对，f3()抛出的编译异常，显示处理*/
//        f3();
    }

    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\HFSS\\3Dmode");

    }
    public static void f4()  {
        /*
        1.这里没有报错，因为这里抛出的是运行时异常
        2.对于运行时异常不要求程序员显示处理，因为有默认处理机制 throw
         */
        f5();
    }
    public static void f5()  throws ArithmeticException {
        int a = 1;
        int b = 0;
        int res = a / b;
    }
}


class Father {
    protected void method() throws RuntimeException {
    }
}

/*
3. 子类重写父类的方法时，对抛出异常的规定：
   【子类重写方法所抛出的异常，只能与父类被重写方法抛出异常一样，
     或者是父类被重写方法抛出异常的子类】
* */
class Son extends Father {
    @Override//重写:访问修饰符可以不一样，但是不能缩小父类方法的访问范围
    public void method() throws NullPointerException {
    }
}
