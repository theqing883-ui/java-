package exeption_.throws_;

//异常处理
        /*
         1.这里是一个编译异常，FileNotFoundException必须处理
         2.可以使用try-catch-finally处理
         3.也可以采用throws，自己不处理，
         【 public void f2()  throws FileNotFoundException】
         4.throws 后面的异常类型可以是方法中产生的异常类型，
            也可以是产生异常的父类 例如Exception
         5.throws 后面也可以是一个列表，可以抛出多种异常
         【public void f2()  throws FileNotFoundException,NullPointerException】
        */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {

    }

    public void f2()  throws FileNotFoundException {
        //创建一个文件流对象
        //异常处理
        /*
         1.这里是一个编译异常，FileNotFoundException必须处理
         2.可以使用try-catch-finally处理
         3.也可以采用throws，自己不处理，
         【 public void f2()  throws FileNotFoundException】
         4.throws 后面的异常类型可以是方法中产生的异常类型，
            也可以是产生异常的父类 例如Exception
         5.throws 后面也可以是一个列表，可以抛出多种异常
         【public void f2()  throws FileNotFoundException,NullPointerException】
        */

            FileInputStream fis = new FileInputStream("D:\\HFSS\\3Dmode");
    }
}

