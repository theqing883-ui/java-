package customexception;

/*
  1. 一般自定义异常都是继承 RuntimeException
    因为定义为RuntimeException 可以有默认处理机制，比较分别
* */
/*
    - 自定义异常的步骤
  1) 定义类：自定义异常类名(程序员自己写) 继承Exception或RuntimeException
  2) 如果继承Exception，属于编译异常
  3) 如果继承RuntimeException，属于运行异常(一般来说，继承RuntimeException)
* */


/*
# throw和throws的区别

|          | 意义                 | 位置        | 后面跟的东西 |
|----------|----------------------|----------- |------------|
| throws   | 异常处理的一种方式      | 方法声明处   | 异常类型     |
| throw    | 手动生成异常对象的关键字 | 方法体中     | 异常对象     |
* */

public class CustomException /*throws AgeException*/{
    public static void main(String[] args) {
        int age = 0;
        //要求年龄在18~120
        if(!(age >= 18 && age <= 120)) {
            //这里可以通过构造器，设置异常信息
            //只要进入这条if语句内部，都会抛出这个异常
            throw new AgeException("年龄需要再18~120之间！");
        }
        System.out.println("输入年龄在正常范围内！");
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}
