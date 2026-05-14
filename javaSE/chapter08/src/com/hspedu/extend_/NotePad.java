package com.hspedu.extend_;

public class NotePad extends Computer {
    private String color;

    public NotePad(String CPU, String GPU, String RAM, String color) {
        super(CPU, GPU, RAM);
        this.color = color;
    }

    protected void inof() {
        getDetails();
        System.out.println("color：" + color);
    }

}
