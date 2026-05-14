package exeption_;

/* 韩顺平教育
异常介绍
● 基本概念
Java语言中，将程序执行中发生的不正常情况称为“异常”。
(开发过程中的语法错误和逻辑错误不是异常)

● 执行过程中所发生的异常事件可分为两大类
1) Error(错误): Java虚拟机无法解决的严重问题。
如: JVM系统内部错误、资源耗尽等严重情况。
比如: StackOverflowError(栈溢出)和OOM(out of memory)，
Error 是严重错误，程序会崩溃。

2) Exception:其它因编程错误或偶然的外在因素导致的一般性问题，
可以使用针对性的代码进行处理。例如空指针访问，试图读取不存在的文件，
网络连接中断等等，Exception分为两大类: 运行时异常[程序运行时，发生的异常]
和编译时异常[编程时，编译器检查出的异常]。

*/

/*
 异常体系图的小结
1. 异常分为两大类，运行时异常和编译时异常。
2. 运行时异常，编译器检查不出来，一般是指编程时的逻辑错误，是程序员应该避免其出现的异常。java.lang.RuntimeException类及它的子类都是运行时异常
3. 对于运行时异常，可以不作处理，因为这类异常很普遍，若全处理可能会对程序的可读性和运行效率产生影响
4. 编译时异常，是编译器要求必须处置的异常。
5. 具体操作：将可能重新问题的代码块用
   try {} catch 包裹,即使出现异常程序也会继续执行

* */

/*
异常/错误体系
├── 错误 (Error) - 严重问题，通常程序无法恢复
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
├── 异常 (Exception)
│   ├── 已检查异常 (Checked Exception) - 编译时检查
│   │   ├── IOException
│   │   ├── SQLException
│   │   └── ClassNotFoundException
│   │
│   └── 运行时异常 (Runtime Exception) - 编译时不检查
│       ├── NullPointerException
│       ├── ArrayIndexOutOfBoundsException
│       ├── ArithmeticException
│       └── IllegalArgumentException
│
└── 编译错误 (Compilation Error) - 不是异常，无法编译
    ├── 语法错误
    ├── 类型不匹配
    └── 变量未初始化
* */



public class Exception01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            int res = a / b;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());//输出异常信息
        }
        /*
         * 1.因为分母为0 ，会抛出异常 ArithmeticException
         * 2.当抛出异常后就退出程序，下面的代码就不运行了
         * 3.这样不好，出现一个不算致命的错误，就程序崩溃
         * 4.此时可以用 异常处理机制解决该问题
         * 5.如果程序员认为某一块问题代码会出现异常问题，则使用try-catch异常处理机制
         * 来解决，从而保证重程序的健壮性
         * 6.具体操作：将可能重新问题的代码块 用try {} catch 包裹,即使出现异常程序也会继续执行
         * 快捷键：ctrl + alt + t
         * */

        System.out.println("程序继续运行！");
    }
}

