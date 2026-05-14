package com.hsp.homework;

public class Homework01 {
    public static void main(String[] args) {
        int start = 1;
        int end = 6;
        String str = "abcdef";
        String newStr = reverse2(str, start, end);
        System.out.println(str);
        System.out.println(newStr);
    }

    public static String reverse(String str, int start, int end) {
        String reversed = new String();
        for (int i = 0; i < start - 1; i++) {
            reversed = reversed + str.charAt(i);
        }
        for (int i = end - 1; i >= start - 1; i--) {
            reversed = reversed + str.charAt(i);
        }
        for (int i = end; i < str.length(); i++) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    public static String reverse2(String str, int start, int end) {
        char[] c = str.toCharArray();
        char temp;
        start--;
        end--;
        while (start < end) {
            temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return new String(c);
    }
}
