package com.hsp.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("E:\\java_code\\chapter23\\src\\com\\hsp\\reflection\\re.properties")));
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("method");
        String fieldName = properties.getProperty("field");
        System.out.println("类路径：" + className + "\n方法名：" + methodName);

        /*Class类*/
        Class cls = Class.forName(className);
        Object o = cls.newInstance();//需要有无参构造器
        System.out.println(cls);
        System.out.println("运行类型：" + o.getClass().getName());

        /*Method类*/
        System.out.println("=========Method===========");
        Method method = cls.getMethod(methodName);//方法名，无论是从什么地方来的
        Method method1 = cls.getMethod("eat");//方法名，无论是从什么地方来的
        Method method2 = cls.getMethod("getAge");//方法名，无论是从什么地方来的

        method.invoke(o);
        method1.invoke(o);
        int age = (int) method2.invoke(o);
        System.out.println("age:" + age);

        /*Field*/
        System.out.println("=========Field===========");
        Field field = cls.getField("name");//成员变量名字，无论是从什么地方来的
        Field field1 = cls.getField(fieldName);//不能得到私有属性
        String name = (String) field1.get(o);
        String name1 = (String) field.get(o);
        System.out.println("name:" + name);
        System.out.println("name1:" + name1);

        /*Constructor*/
        System.out.println("=========Constructor==========");
        Constructor constructor = cls.getConstructor();//无参构造器
        System.out.println("constructor:" + constructor);
        Constructor constructor1 = cls.getConstructor(String.class);//String.class是String的一个Class对象
        System.out.println("constructor1:" + constructor1);



    }
}
