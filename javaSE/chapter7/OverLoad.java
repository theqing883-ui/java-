// 方法重载：同一个类中存在同名的方法，但是要求形参不一样
// 作用：减轻起名的麻烦
// 要求：(必须在调用的时候可以区分)
/*
	1、方法明相同
	2、形参的类型、个数、顺序至少其中之一不一样，形参名无要求
	3、返回类型不影响，下面两个不构成方法的重载
	public  int calculate(int num1, int num2){
		int sum;
		sum = num1 + num2;
		return sum;
	}

	public double calculate(int num1,int num2){

		return num1 + num2;
	}
*/
public class OverLoad {
	public static void main(String[] args){
		int num1 = 10;
		double num2 = 10.10;
		Calculator myCalculator = new Calculator();
		System.out.println(myCalculator.calculate(num1, num1));
		System.out.println(myCalculator.calculate(num1, num2));
		System.out.println(myCalculator.calculate(num2, num1));
	}
}

class Calculator{
	public int calculate(int num1, int num2){
		int sum;
		sum = num1 + num2;
		return sum;
	}

	public double calculate(int num1, double num2){

		return num1 + num2;
	}
	public double calculate(double num1, int num2){

		return num1 + num2;
	}
}