package com.hspedu.poly_;

public class Master {
    private String name;

    public Master(String _name) {
        this.name = _name;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String _name) {
        this.name = _name;
    }

    //利用多态机制简化代码,父类的引用可以指向子类的对象，编译对象是Animal执行对象为Cat
    public void feed(Animal animal,Food food){
        System.out.println("主人 " + this.name + " 给" + animal.getName() + " 喂 " + food.getName());

    }


//    //主人给小狗喂骨头
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人 " + this.name + " 给" + dog.getName() + " 喂 " + bone.getName());
//    }
//
//    //主人给小猫喂鱼
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人 " + this.name + " 给" + cat.getName() + " 喂 " + fish.getName());
//
//    }
}
