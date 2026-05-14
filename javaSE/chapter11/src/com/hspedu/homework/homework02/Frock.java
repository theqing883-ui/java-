package com.hspedu.homework.homework02;

public class Frock {
    private static int currentNum = 100000;
    private  int serialNumber;
    private static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public  int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        serialNumber = getNextNum();
    }
}
