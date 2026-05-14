package com.hspedu.poly_.polyarr;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class Test {
    public static void main(String[] args) {
        Person[] Persons = new Person[5];

        Persons[0] = new Person(45, "Smith");

        Persons[1] = new Student("大橘", 130,15);
        Persons[2] = new Student("小白", 140,20);

        Persons[3] = new Teacher("Fe", 20000, 35);
        Persons[4] = new Teacher("Ga", 30000, 30);

        for (Person person : Persons) {
            // Persons[i]的编译类型为Person，运行类型根据等号右边的确定
            System.out.println(person.say());//动态绑定机制

            // 向下转型
            if(person instanceof Student){//判断person的运行类型是不是Student的本类或子类
                Student student = (Student) person;// 将指向子类(Student)的父类(Person)引用强转为子类(Student)
                student.study();
//                ((Student)person).study();
            }else if(person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                teacher.teach();
            }

        }
//        System.out.println(Persons[0].say());
//        System.out.println(Persons[1].say());
//        System.out.println(Persons[2].say());
//        System.out.println(Persons[3].say());
//        System.out.println(Persons[4].say());

//        Persons[1].getScore();

    }
}
