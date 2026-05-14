package com.hsp.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
/*
- 创建文件对象相关构造器和方法
  ▶ 相关方法
  - new File(String pathname) //根据路径构建一个File对象
  - new File(File parent,String child) //根据父目录文件+子路径构建
  - new File(String parent,String child) //根据父目录+子路径构建


要不要我帮你把这些构造器整理成**清晰的用法说明表**？
* */
public class FileCreate {
    public static void main(String[] args) {
//        create01();
    }
    //方式1 new File(String pathname)
    @Test//利用JUnit测试
    public void create01(){
        String filePath = "E:\\java_code\\chapter18\\src\\test\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    //方式2 new File(File parent,String child)
    @Test
    /*
    E:\java_code\chapter18\src\test\news1.txt
    parent：E:\java_code\chapter18\src\test\
    child: news1.txt
    * */
    public void create02(){
        File parentFile = new File("E:\\java_code\\chapter18\\src\\test\\");
        String  childFile = "news2.txt";
        File file = new File(parentFile,childFile);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    //方式3 new File(String parent,String child)
    @Test
    public void create03(){
//       String parentFile = "E:\\java_code\\chapter18\\src\\test\\";
       String parentFile = "E:/java_code/chapter18/src/test/";
       String childFile = "news3.txt";
       File file = new File(parentFile,childFile);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
