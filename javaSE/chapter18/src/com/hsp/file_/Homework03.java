package com.hsp.file_;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //加载配置文件
        String filePath = "E:\\java_code\\chapter18\\src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new BufferedReader(new FileReader(filePath)));
//        properties.list(System.out);
        //根据配置文件创建对象
        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "") ;
        String color = properties.get("color") + "";
        Dog dog = new Dog(name, age, color);
        //将创建的对象序列化
        String destPath = "E:\\java_code\\chapter18\\src\\dog.dat";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(destPath));
        out.writeObject(dog);
        out.close();

        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(destPath));
        Dog dog1 = (Dog)in.readObject();
        System.out.println(dog1);


    }
}
class Dog implements Serializable{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
