package com.hsp.stringbuffer_;

public class StringBufferExercise {
    public static void main(String[] args) {
        String price = "15434523564.59";
        StringBuffer sb = new StringBuffer(price);
        int len = sb.length();
        System.out.println(len);
        int index = sb.indexOf(".");
        System.out.println(index);
        int newIndex = index;
        for (int i = index - 3; i > 0; i -= 3) {//每次移动三位，小于等于0时结束
            sb.insert(i, ",");
        }

        System.out.println(sb);


    }
}
