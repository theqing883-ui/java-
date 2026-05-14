//数组
import java.util.Scanner;
public class array1{
	public static void main(String[] args) {
		//1.定义
		// 数据类型 数组名[] = new 数据类型[大小]
		//或者 1.1(动态初始化) 数据类型[] 数组名 = new 数据类型[大小]
		//或者 1.2(动态初始化) 先声明再赋值,声明时为分配空间，赋值时才分配
		//		eg:int[] a;/int a[]
		//    	a = new int[10]
		//或者 1.3(静态初始化)  知道数组的大小和值
		// 		eg:double[] hens = {3, 5, 1, 3.4, 2, 50};
		//1.4 未赋值时，int short byte long 默认为0
		//	   			float double 默认为0.0 
		//				char 默认为\u0000，boolean 默认为false。，String 默认为null
		double[] hens = {3, 5, 1, 3.4, 2, 50};
		// double[] hens = new double[6];
		// double[] hens;//
		// hens = new double[6]
		//double hens[] = {3, 5, 1, 3.4, 2, 50};


		//可以通过 数组名.length 得到数组的大小
		//遍历数组：下标是从0开始的
		for(int i = 0; i < hens.length; i++){
			System.out.println(hens[i]);
		}

		Scanner myScanner = new Scanner(System.in);
		double[] score = new double[5];
		for(int i = 0; i < score.length; i++){
			System.out.println("输入数据：");
			score[i] = myScanner.nextDouble();
		}
		System.out.println("数组的数据：");
		for(int i = 0; i < score.length; i++){
			
			
			System.out.print(score[i] + "\t");
		}

		System.out.println(" ");


		char[] letter = new char[26];
		int j = 0;
		for(char i = 'A'; i <= 'Z'; i++, j++){
			letter[j] = i;
		}
		for(j = 0; j < letter.length; j++){
			System.out.print(letter[j] + "\t");
		}
		System.out.println(" ");



		//

		int[] num = {4, -1, 9, 10, 23};
		// int result = num[0];
		// int sum = num[0];
		// for(int i = 1; i < num.length; i++){
		// 	result = Math.max(result, num[i]);
		// 	sum += num[i];
		// }


		int max = num[0];
		int maxIdex = 0;
		for(int i = 1; i < num.length; i++){
			if(max < num[i]){
				maxIdex = i;
				max = num[maxIdex];
			}
		}
		
		System.out.println("最大值引索：" + maxIdex);
		System.out.println("最大值：" + max);
		// System.out.println("最大值：" + result);
		// System.out.println("和：" + sum);
		// System.out.println("平均值：" + (double)sum / num.length);
	}
}