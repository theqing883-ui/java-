//if教学
import java.util.Scanner;

public class ifelse{
	public static void main(String[] args) {
		
		Scanner myscanner = new Scanner(System.in);
		// System.out.println("请输入年龄：");
		// int age = myscanner.nextInt();

		// if(age >= 18){
		// 	System.out.println("你已经成年了！");
		// }else{
		// 	System.out.println("你还没有成年！");

		// }

		// System.out.println("请输入第一个数：");
		// double num1 = myscanner.nextDouble();
		// System.out.println("请输入二个数：");
		// double num2 = myscanner.nextDouble();

		// if((num1 > 10.0) && (num2 < 20.0)){
		// 	double  num = num1 +num2;
		// 	System.out.println("两数之和为："+ num);
		// }


		// System.out.println("请输入第一个整数：");
		// int num3 = myscanner.nextInt();
		// System.out.println("请输入二个整数：");
		// int num4 = myscanner.nextInt();

		// if((Math.abs(((num3 + num4) % 3) - 0) < 1) &&
		// 	 (Math.abs(((num3 + num4) % 3) - 0) < 1)){
		// 	System.out.println("两数之和可以被3和5整除");
		// }else{
		// 	System.out.println("两数之和不可以被3和5整除");
		// }

		// System.out.println("请输入一个年份：");
		// int year = myscanner.nextInt();

		// if(((Math.abs((year % 4) - 0) < 1) &&
		// 	(Math.abs((year % 100) - 0) >= 1)) ||
		// 	(Math.abs((year % 400) - 0) < 1)){
		// 	System.out.println(year + "是闰年");
		// }else{
		// 	System.out.println(year + "不是闰年");
		// }

		System.out.println("请输入信用分1~100：");
		double score = myscanner.nextDouble();

		if((100 >= score) && (score >= 0)){
		if(score == 100){
			System.out.println("信用极好！");

		}else if(score >= 80){

			System.out.println("信用优秀！");
		}else if(score >=  60){

			System.out.println("信用及格！");
			
		}else{
			System.out.println("信用不及格！");
			
		}
		}else{
			System.out.println("输入不合理！");
		}

	}
}
