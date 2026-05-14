package com.hspedu.enum_;

/*
1. toString:Enum类已经重写过了，返回的是当前对象名,子类可以重写该方法，用于返回对象的属性信息
2. name: 返回当前对象名（常量名），子类中不能重写
3. ordinal: 返回当前对象的位置号，默认从0开始
4. values: 返回当前枚举类中所有的常量
5. valueOf: 将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常!
6. compareTo: 比较两个枚举常量，比较的就是位置号!
* */
public class EnumMethod {
    public static void main(String[] args) {
        //以Season2枚举类为例
        Season2 autumn = Season2.AUTUMN;

        //2. name: 返回当前对象名（常量名），子类中不能重写
        System.out.println(autumn.name());

        //3. ordinal: 返回当前对象的编号，默认从0开始
        //AUTUMN 枚举对象是第2个，因此输出2
        System.out.println(autumn.ordinal());

        //4. values: 返回当前枚举类中所有的常量
        //【public static com.hspedu.enum_.Season2[] values();】
        //从反编译可以看见 values() 是静态方法 返回Season2[]
        //含有定义的所有 对象常量
        Season2[] season2s = Season2.values();
        for (Season2 season2 : season2s) {
            System.out.println(season2);
        }

        //5. valueOf: 将字符串转换成枚举对象，要求字符串必须为已有的常量名，
        // 否则报异常!,也是一个静态方法
        /*执行流程
         * 1.根据你输入的"AUTUMN"到Season2的枚举对象取查找
         * 2.如果找到了，就返回该对象，没找到就报异常
         * */
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println(autumn1 == autumn);


        //6. compareTo: 比较两个枚举常量，比较的就是位置号【ordinal 】!
        /*
        public final int compareTo(E o) {
            //self = this;
            //other = (Enum<?>)
        return self.ordinal - other.ordinal;
        }

        autumn的编号 - autumn1的编号
        * */
        System.out.println(autumn.compareTo(autumn1));

    }
}

