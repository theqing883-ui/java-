package com.hspedu.extend_;

public class PC extends Computer {
    private String brand;

    public PC(String CPU, String GPU, String RAM, String brand) {
        super(CPU, GPU, RAM);
        this.brand = brand;
    }

    public void info() {

        getDetails();
        System.out.println("品牌：" + brand);
    }
}
