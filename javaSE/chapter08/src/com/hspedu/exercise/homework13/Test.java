package com.hspedu.exercise.homework13;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("香芋", "女", 18, 123456);
        Teacher teacher = new Teacher("王俊", "男", 38, 16);

        student.printInfo();
        teacher.printInfo();

        Person[] persons = new Person[4];
        persons[0] = new Student("香芋", "女", 18, 123456);
        persons[1] = new Student("香草", "女", 19, 123457);
        persons[2] = new Teacher("王俊", "男", 38, 16);
        persons[3] = new Teacher("黄玉燕", "女", 30, 8);
        //冒泡
        //1.在main静态方法中不能直接调用同类中实例方法，除非创建该类的对象，其他非静态方法可以
        //2.当方法是static（静态方法）时，可直接通过类名调用
        new Test().bubbleSort(persons);
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        for (int i = 0; i < persons.length; i++) {
            new Test().try_(persons[i]);
        }
    }

    public void bubbleSort(Person[] persons) {
        Person temp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getAge() < persons[j + 1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    //在main静态方法中不能直接调用同类中实例方法，除非创建该类的对象，其他非静态方法可以
    public void bubbleSort2(Person[] persons) {
        bubbleSort(persons);
    }

    public void try_(Person person) {
        if (!(person instanceof Student || person instanceof Teacher)) {
            System.out.println("无法调用");
            return;
        }
        if (person instanceof Student) {
            Student student = (Student) person;
            student.study();
            return;
        }
        Teacher teacher = (Teacher) person;
        teacher.teach();
    }
}

