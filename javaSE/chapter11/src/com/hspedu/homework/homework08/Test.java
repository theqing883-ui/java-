package com.hspedu.homework.homework08;

public class Test {
    public static void main(String[] args) {
        Color green = Color.GREEN;
        green.show();
        switch (green) {
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case YELLOW:
                System.out.println("yellow");
                break;
            case GREEN:
                System.out.println("green");
                break;
            default:
                System.out.println("没匹配到");

        }
    }
}
