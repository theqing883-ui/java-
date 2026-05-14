package com.hspedu.extend_;

public class Computer {
    private String CPU;
    private String GPU;
    private String RAM;

    Computer(String CPU, String GPU, String RAM) {
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
    }

    public void getDetails() {
        System.out.println("这台电脑的信息");
        System.out.println("CPU: " + CPU + ", GPU: " + GPU +
                ", RAM: " + RAM);
    }

}
