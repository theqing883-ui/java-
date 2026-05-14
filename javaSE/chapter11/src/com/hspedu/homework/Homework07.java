package com.hspedu.homework;

public class Homework07 {
    public static void main(String[] args) {
        Car car = new Car(-1);
        Car.Air air = car.new Air();//注意 外部类名.内部类名 内部对象名 = 外部对象名.new 内部类名();
        Car.Air air1 = car.getAir();
        System.out.println(air == air1);
        air.flow();
        car.setTemperature(10);
        air1.flow();
        car.setTemperature(100);
        air1.flow();
    }
}

class Car {
    private double temperature;
    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("吹冷风");
            } else if (temperature < 0) {
                System.out.println("吹热风");
            } else {
                System.out.println("关闭空调");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
