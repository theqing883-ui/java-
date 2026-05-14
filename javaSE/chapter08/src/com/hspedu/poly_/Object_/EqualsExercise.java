package com.hspedu.poly_.Object_;

public class EqualsExercise {
    public static void main(String[] args) {
        Person person = new Person(10, '男', "jake");
        Person person1 = new Person(10, '男', "jake");

        System.out.println(person.equals(person1));//false
        //未重写前，使用的是Object的equals方法,比较两者是否指向同一个对象
        //重写后，使用的是Person 重写后的equals方法,比较两者内容【属性的值】是否相等
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(int age, char gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    //重写equals
    public boolean equals(Object obj) {

        if (this == obj) { //判断是否是同一个对象
            return true;
        } else {
            if (obj instanceof Person) {//判断obj是不是Person类或者Person的子类
                Person person = (Person) obj;//向下转型
//            return this.age == person.age && this.gender == person.gender && this.name.equals(person.name);
                return this.age == person.getAge() && this.gender == person.getGender() && this.name == person.getName();
                // 判断两者所有属性值是否相等，并返回结果
            } else {
                return false;
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
