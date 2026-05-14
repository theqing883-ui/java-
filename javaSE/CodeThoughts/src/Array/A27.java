package Array;

import java.util.Scanner;

public class A27 {
    public static void main(String[] args) {
//        new Solution().generateMatrix(4);
        Scanner myScanner  = new Scanner(System.in);
        int N = myScanner.nextInt();
    }
}

//class Solution {
//    public int[][] generateMatrix(int n) {
//        int[][] Matrix = new int[n][n];
//        int count = 1;
//        int startX = 0;
//        int startY = 0;
//        int offset = 1;
//        int times = n/2;
//        while(times-- > 0){
//            for(int j = startY; j < n - offset; j++){
//                Matrix[startX][j] = count++;
//            }
//            for(int i = startX; i < n - offset; i++){
//                startY = n - offset;
//                Matrix[i][startY] = count++;
//            }
//            for(int j = startY; j >= offset; j--){
//                startX = n - offset;
//                Matrix[startX][j] = count++;
//            }
//            for(int i = startX; i > offset - 1; i--){
//                startY = offset - 1;
//                Matrix[i][startY] = count++;
//            }
//            startX = offset;
//            startY = offset;
//            offset++;
//        }
//        if(n % 2 != 0){
//            Matrix[n-offset][n-offset] = n * n;
//        }
//        return Matrix;
//
//    }
//}
