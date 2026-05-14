package com.hspedu.extend_;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小米";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(90);
        pupil.print();

        System.out.println("================ ");
        Graduate graduate = new Graduate();
        graduate.name = "大米";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(99);
        graduate.print();
    }
}
