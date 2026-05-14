package com.hsp.file_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInputProcessingStreams_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {

        String filePath = "E:\\java_code\\chapter18\\src\\test\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。如果没有输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕，遇到读取汉字等容易出现乱码
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);//转成char显示,
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源。
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void readFile02() {
        String filePath = "E:\\java_code\\chapter18\\src\\test\\hello.txt";
        int readLen = 0;
        byte[] buffer = new byte[1024];//一次读8个字节，效率更高
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多buffer.length个字节的数据。如果没有输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕，
            //如果读取正常，返回的是实际返回内容的字节数，读取的内容在buffer中。
            while ((readLen = fileInputStream.read(buffer)) != -1) {
                System.out.print(new String(buffer,0,readLen));//转成char显示,
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源。
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
