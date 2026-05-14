package com.hsp.file_.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        //文件复制
        String SrcFilePath = "E:\\java_code\\chapter18\\src\\test\\1.png";
        String destFilePath = "E:\\java_code\\chapter18\\src\\1.png";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] buffer = new byte[1024];//定义字节数组，提高效率
        int readLen = 0;
        try {
            fis = new FileInputStream(SrcFilePath);
            fos = new FileOutputStream(destFilePath);
            while ((readLen = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readLen);//边读边写
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{//关闭流，释放资源
            try {
                if(fis != null){
                    fis.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
