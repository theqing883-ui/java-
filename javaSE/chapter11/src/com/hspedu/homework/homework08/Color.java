package com.hspedu.homework.homework08;

public enum Color implements IA {
   RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
   private int redValue;
   private int greenValue;
   private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }
    public void show(){
        System.out.println("redValue: " + this.redValue);
        System.out.println("greenValue: " + this.greenValue);
        System.out.println("blueValue: " + this.blueValue);
    }
}
