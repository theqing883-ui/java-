package com.hspedu.exercise;

public class Homework03 {
    public static void main(String[] args) {
        //向上转型
        Teacher teacher = new Professor(45,40000,"Smith");
        Teacher teacher1 = new AssociateProfessor(36,30000,"Lucy");
        Teacher teacher2 = new Lecturer(30,20000,"John");
        teacher.introduce();
        teacher1.introduce();
        teacher2.introduce();
        // 2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用,编译类型中没有的属性，
        // 在运行类型中有，同样不能访问，除非向下转型
        double level = ((Professor) teacher).level;


    }
}

class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(int age, String post, double salary, String name) {
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.name = name;
    }

    public void introduce() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Professor extends Teacher {
    double level = 1.3;

    public Professor(int age, double salary, String name ) {
        super(age, "教授", salary, name);
//        this.level = level;
    }

    public void introduce() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", post='" + this.getPost() + '\'' +
                ", salary=" + this.getSalary()  +
                ", level=" + level +
                '}';
    }
}

class AssociateProfessor extends Teacher {
    private double level = 1.2;

    public AssociateProfessor(int age, double salary, String name) {
        super(age, "副教授", salary, name);
//        this.level = level;
    }

    public void introduce() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "AssociateProfessor{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", post='" + this.getPost() + '\'' +
                ", salary=" + this.getSalary()  +
                ", level=" + level +
                '}';
    }
}

class Lecturer extends Teacher {
    private double level = 1.1;

    public Lecturer(int age, double salary, String name) {
        super(age, "讲师", salary, name);
//        this.level = 1.2;
    }
    public void introduce() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", post='" + this.getPost() + '\'' +
                ", salary=" + this.getSalary()  +
                ", level=" + level +
                '}';
    }
}

