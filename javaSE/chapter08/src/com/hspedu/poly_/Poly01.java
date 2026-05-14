package com.hspedu.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master tom = new Master("CC");

        Dog tiger = new Dog("Tiger");
        Bone mua = new Bone("牛骨");
        tom.feed(tiger, mua);

        Cat cat = new Cat("大橘~~~");
        Fish fish = new Fish("小黄鱼~~~");
        tom.feed(cat, fish);

        Pig pig = new Pig("佩奇");
        Rice rice = new Rice("稻米");
        tom.feed(pig, rice);



    }
}
