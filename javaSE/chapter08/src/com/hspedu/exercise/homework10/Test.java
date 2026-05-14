package com.hspedu.exercise.homework10;

public class Test {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("jake", 32, "医师", "女", 10000);
        Doctor doctor1 = new Doctor("jak", 32, "医师", "女", 10000);

        System.out.println(doctor1.equals(doctor));
    }
}
