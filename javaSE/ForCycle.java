//for 循环
import java.util.Scanner;
public class ForCycle{
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++){
			System.out.println("哇哈哈哈哈" + i);
		}
		// 等效于
		//int i = 1
		// for(; i <= 10;){
		// 	System.out.println("哇哈哈哈哈" + i);
		//  i++
		// }

		//补充
		// for( ; ; ){//死循环
		// 	System.out.println("哇哈哈哈哈" + i);
		// }

		//1.可以有多条初始化语句，但要求类型一样，循环变量的迭代也可以执行多条语句
		//2.循环条件的返回值永远是boolean值
		int count = 3;
		for(int i = 0, j = 0; i < count;  i++, j += 2){
			System.out.println("i=" + i + "\tj=" + j);
		}

		//练习
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入0~100的一个数:");
		double endnum = myscanner.nextDouble();
		int sum = 0;
		int count2 = 0;
		for(int num = 1; num <= endnum ; num++){
			if(num%9 == 0){
				count2++;
				sum += num;
				System.out.println("num=" + num);

			}
		}
		System.out.println("个数：" + count2 + "总和" + sum);

		for(int num1 = 0, num2 = 5; num1 <= 5 ; num1++,num2--){
			System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		}

	}
}