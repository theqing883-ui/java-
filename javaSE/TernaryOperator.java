//三元运算符
// 基本语法(底层为 if---else---)
// 条件表达式？表达式1：表达式2；
// 运算规则：
// 1.如果条件表达式为true，运算后的结果是表达式1(表达式2不会执行)；
// 2.如果条件表达式为false，运算后的结果是表达式2(表达式1不会再执行)；

public class TernaryOperator{
	public static void main(String[] args) {
		
		int a = 10, b = 99;
		// int b = 99;
		int result = a > b ? a++ : b++;
		System.out.println("result=" + result + "\t b=" + b);

		//表达式1和表达式2要为可以赋给的接收变量的类型（或者可以自动转换），
		int n1 = 3;
		int n2 = 8;
		int n3 = n1 > n2 ? a : b;
		// int n3 = n1 > n2 ? 1.1 : 2.3;//不行
		double n4 = n1 > n2 ? a : b + 2;//可以
		char c = 'a';
		int n5 = c;
		System.out.println("n4=" + n4 + "\t n5=" + n5);


		//比较三个数的大小
		int x = 6;
		int y = 2;
		int z = 3;

		int result1 = x > y ? x : y;
		int result2 = result1 > z ? result1 : z;
		System.out.println("result2=" + result2);
		//三元运算符的嵌套(不推荐)
		int max = (x > y ? x : y) > z ? (x > y ? x : y) : z;
		System.out.println("max=" + max);

		//单目运算（只有一个操作数，++，--，！，~）和赋值运算的运算顺序为从右往左


	}
}
