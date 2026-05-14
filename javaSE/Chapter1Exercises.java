//练习
import java.util.Scanner;
public class Chapter1Exercises{
	//main方法
	public static void main(String[] args) {

		//练习1
		int money = 100000;
		int count = 0;
		while(true){
			if(money > 50000){
				money *= 0.95;
				count++; 
			}else if(money > 1000){
				money -= 1000;
				count++; 
			}else{
				break;
			}
		}
		System.out.println("该人可以经过" + count + "次路口。");

		//练习2
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入一个数：");
		double num = myScanner.nextDouble();

		if(num > 0){
			System.out.println(num + "大于0");
		}else if(num == 0){
			System.out.println(num + "等于0");
		}else{
			System.out.println(num + "小于0");
		}

		//练习3
		System.out.println("请输入一个数：");
		int num1 = myScanner.nextInt();
		int units = num1 % 10;
		int tens = num1 / 10 % 10;
		int hundreds = num1 / 100 % 10;
		// System.out.println(units);
		// System.out.println(tens);
		// System.out.println(hundreds);
		if(units * units * units + tens * tens * tens + 
			hundreds * hundreds * hundreds == num1){
			System.out.println(num1 + "是水仙数");
		}
		else{
			System.out.println(num1 + "不是水仙数");				
		}


		//练习4
		int count1 = 0;
		for(int num2 = 1; num2 <= 100; num2++){
			if(num2 % 5 != 0){
				System.out.print(num2 + "\t");
				count1++;
				if(count1 % 5 == 0){
					System.out.print("\n");
				}
			} 
		}



		//练习5 A65 a 97

		// for(char c1 = 'a'; c1 <= 'z'; c1++){
		// 	System.out.print(c1);
		// }
	
		for(int i = 1; i <= 2; i++){
			char a;
			if(i == 1){
				a = 'a';
			}else{
				a = 'A';
			}
			for(int j = 0; j < 26; j++){
				char b = (char)( a + j);
				System.out.print(b + "\t");
			}
			System.out.print("\n");
		}

		//练习6
		double sum = 0;
		int start = 1;
		int total = 100;
		for(int i = start; i <= total; i++){
			if(i % 2 != 0){
				sum += 1.0/i;
				if(i == start){
					System.out.print(i);
				}else{
					System.out.print("+" + 1 + "/" +i);	
				}
			}
			else{
				sum -= 1.0/i;
				System.out.print("-" + 1 + "/" +i);
			}
		}
		System.out.println("=" + sum);

		//练习7
		double sum1 = 0;
		int start1 = 1;
		int total1 = 100;
		for(int i = start1; i <= total1; i++){
			int sum2 = 0;
			for(int j = start; j <= i; j++){
				sum2 += j;
				// if(j == start){
				// 	System.out.print("(" + j);
				// }else if(j == i){
				// 	System.out.print(j + ")");
				// }
				// else{
				// 	System.out.print("+" + j);	
				// }
			}
			sum1 += sum2;
		}
		System.out.println("=" + sum1);


	}
}