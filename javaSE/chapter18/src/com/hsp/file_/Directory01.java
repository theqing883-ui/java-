package com.hsp.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory01 {
    public static void main(String[] args) {

    }
    //判断 D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {


        String directoryPath = "E:\\demo\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
           if (file.delete()) {//只删除了c
               System.out.println("删除成功");
           }else{
               System.out.println("删除失败");
           }
        } else {
            if(file.mkdirs()) {//E:\demo 创建一级目录，这种情况用mkdir
                System.out.println(directoryPath + " 创建成功...");
            } else {
                System.out.println(directoryPath + " 创建失败...");
            }
        }
        /*

        # IO流 的分类
        - 按操作数据单位不同分为：字节流(8 bit) 二进制文件，字符流(按字符) 文本文件
        - 按数据流的流向不同分为：输入流，输出流
        - 按流的角色的不同分为：节点流，处理流/包装流

        | （抽象基类） | 字节流       | 字符流   |
        | -----------| ------------ | -------- |
        | 输入流       | InputStream  | Reader   |
        | 输出流       | InputStream | Writer   |
        InputStream、InputStream和Reader、Writer都是抽象类

        1) Java的IO流共涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的。
        2) 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。

        * */
    }
}
