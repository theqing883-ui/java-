package com.hspedu.exercise;

public class Homework01 {
    public static void main(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person(20, "员工", "jake");
        person[1] = new Person(24, "员工2", "Lucy");
        person[2] = new Person(50, "老板", "Smith");
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getAge() < person[j + 1].getAge()) {
                    int temp = person[j].getAge();
                    person[j].setAge(person[j + 1].getAge());
                    person[j + 1].setAge(temp);
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
//            System.out.println(person[i].toString());
            System.out.println(person[i]);//默认调用toString()方法
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person() {
    }

    public Person(int age, String job, String name) {
        this.age = age;
        this.job = job;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
