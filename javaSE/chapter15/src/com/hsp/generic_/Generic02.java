package com.hsp.generic_;

import java.util.*;

public class Generic02 {
    public static void main(String[] args) {
        /*
        泛型的声明
        • interface 接口<T>{}
        • class 类<K,V>{}
          例如：List、ArrayList
        说明：
        1. T、K、V 不代表值，而是表示类型。
        2. 任意字母都可以，常用 T（Type 的缩写）。

        泛型的实例化
        在类名后面指定类型参数的具体类型。例如：
        1. List<String> strList = new ArrayList<String>();
        2. Iterator<Customer> iterator = customers.iterator();
        * */

        Student jake = new Student(10, "jake");
        Student james = new Student(20, "james");
        Student john = new Student(30, "john");

        HashSet<Student> students = new HashSet<>();
        students.add(jake);
        students.add(james);
        students.add(john);
       students.add(new Student(11, "111"));

        System.out.println("============hashSet============ ");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("======================= ");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
        System.out.println("==============hashMap");
        HashMap<String, Student> stringStudentHashMap = new HashMap<>();
        stringStudentHashMap.put("jake", jake);
        stringStudentHashMap.put("james", james);
        stringStudentHashMap.put("john", john);
        stringStudentHashMap.put("111",new Student(11, "111"));
        Set<Map.Entry<String, Student>> set = stringStudentHashMap.entrySet();
        for (Map.Entry<String, Student> entry : set) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
        System.out.println("==========================");
        Iterator<Map.Entry<String, Student>> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Student> entry = iterator2.next();
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }


    }
}

class Student {
   public String name;
   public int age;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
