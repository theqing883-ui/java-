package com.hspedu.override;

public class Student extends Person {
    private long id;
    private double score;
    public Student(String name, int age, long id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public void say(){
        super.say();
        System.out.println(" ID： "+ id + " 分数： " + score);
    }
}
