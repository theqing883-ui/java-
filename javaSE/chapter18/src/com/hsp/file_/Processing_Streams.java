package com.hsp.file_;

/*

# 节点流和处理流
## 节点流和处理流的区别和联系
1.  节点流是底层流/低级流，直接跟数据源相接。
2.  处理流(包装流)包装节点流，既可以消除不同节点流的实现差异，
也可以提供更方便的方法来完成输入输出。[源码理解]
3.  处理流(也叫包装流)对节点流进行包装，使用了修饰器设计模式，
不会直接与数据源相连 [模拟修饰器设计模式=> 小伙伴就会非常清楚.]

---

## 处理流的功能主要体现在以下两个方面:
1.  **性能的提高**：主要以增加缓冲的方式来提高输入输出的效率。
2.  **操作的便捷**：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，
    使用更加灵活方便

* */

public class Processing_Streams {
    public static void main(String[] args) {
    /*
        分类	字节输入流	字节输出流	字符输入流	字符输出流
        抽象基类	InputStream	OutputStream	Reader	Writer
        访问文件	FileInputStream	FileOutputStream	FileReader	FileWriter
        访问数组	ByteArrayInputStream	ByteArrayOutputStream	CharArrayReader	CharArrayWriter
        访问管道	PipedInputStream	PipedOutputStream	PipedReader	PipedWriter
        访问字符串	StringReader（注：原表中字节输入流对应位置为空，字符输入流为 StringReader）	—	StringReader	StringWriter
        缓冲流	BufferedInputStream	BufferedOutputStream	BufferedReader	BufferedWriter
        转换流	—	—	InputStreamReader	OutputStreamWriter
        对象流	ObjectInputStream	ObjectOutputStream	—	—
        抽象基类	FilterInputStream	FilterOutputStream	FilterReader	FilterWriter
        打印流	—	PrintStream	—	PrintWriter
        推回输入流	PushbackInputStream	—	PushbackReader	—
        特殊流	DataInputStream	DataOutputStream	—	—

    * */
    }
}
