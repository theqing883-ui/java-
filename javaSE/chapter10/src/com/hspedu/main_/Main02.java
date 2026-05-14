package com.hspedu.main_;

public class Main02 {
    public static void main(String[] args) {
        //遍历字符串数组args 可以在 编辑配置->程序实参，进行传入
        for(int i = 0; i < args.length; i++){
            System.out.print("第"+ (i + 1) + "个元素是" + args[i] + "\n");
        }
    }
}
