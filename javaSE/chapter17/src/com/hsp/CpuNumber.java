package com.hsp;

public class CpuNumber {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNumber = runtime.availableProcessors();
        System.out.println(cpuNumber);
    }
}
