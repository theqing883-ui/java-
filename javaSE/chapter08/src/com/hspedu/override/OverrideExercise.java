package com.hspedu.override;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person();
        person.say();

        System.out.println();
        System.out.println("==========");
        Person person2 = new Person("JAKE",30);
        person2.say();

        System.out.println();
        System.out.println("==========");
        Student student = new Student("Smith",25,2020302715,90);
        student.say();
    }
}
