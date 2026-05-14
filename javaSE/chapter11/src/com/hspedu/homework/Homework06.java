package com.hspedu.homework;

interface Vehicle {
    void work();
}

public class Homework06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", "火焰山");
        person.getVehicle().work();
    }
}

class Horse implements Vehicle {
    public void work() {
        System.out.println("Horse works");
    }
}

class Boat implements Vehicle {
    public void work() {
        System.out.println("Boat works");
    }
}

class fly implements Vehicle {
    public void work() {
        System.out.println("fly works");
    }
}

class VF {
    public static Horse horse = new Horse();

    private VF() {
    }

    ;

    public static Vehicle getV(String station) {
        if ("大河".equals(station)) {
            return new Boat();
        } else if ("火焰山".equals(station)) {
            return new fly();
        } else {
            return new Horse();
        }
    }

}

class Person {
    private Vehicle vehicle;
    private String name;

    public Person(String name, String station) {
        this.name = name;
        this.vehicle = VF.getV(station);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }
}
