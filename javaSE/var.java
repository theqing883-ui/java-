
public class var{

	public static void main(String[] args){
		// int 和 doubl类型也不可以相互赋值
		int age = 20;
		double score = 88.6;
		char gender = '男';
		String name = "jack";
		System.out.println("人的信息入下:\n");
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(score);

		//1.当左右两边都是数值型时，则做加法运算
		//2.当左右两边有一方为字符串，则做拼接运算
		//3.运算顺序从左往右
		System.out.println(100+98);
		System.out.println("100"+98);
		System.out.println(100+98+"HELLO");
		System.out.println("HELLO"+100+98);
		// byte(1) short(2) int(4) long(8) float(4) double(8) char(2)
		// boolean(1)
		int n1 = 10;
		//int n2  = 10L;错误写法
		long n2  = 10L;

		//Java的浮点型常量默认为double型，声明float型常量，须后加f或F
		//低精度可以放到高精度，高精度不可以放到低精度
		//float num1 = 1.2 error
		float num1 = 1.2f;
		double num2 = 1.2f;
		double num3 = .123456789;
		double num4 = 1.23456789111111e2;
		System.out.println(num3);
		System.out.println(num4);


		 //使用陷阱
		double num5 = 2.7;
		double num6 = 8.1/3;//2.6999999999999997
		System.out.println(num5);
		System.out.println(num6);
		//得到一个重要的使用点：当我们对运算结果是小数的进行相等判断是，要小心
		//应该是以两个数的差值的绝对值，在某个精度范围类判断
		/**
		 * if (num5 == num6){
		 * 		System.out.println("相等");
		 * } 
		 */

		 if (Math.abs(num5 - num6) < 0.0000001){
		 	System.out.println("相等");
		 } 
		 

		 //char 的基本使用
		 char c1 = 'a';
		 char c2 = '\t';
		 char c3 = '韩';
		 char c4 = 97;//说明：字符类型可以直接存放一个整型数字,输出时可以表示unicode码(ASCII的升级->unicode->utf-8)中97代表的字符
		 char c5 = '9';
		 //char 类型可以存放整型常量值，但不可以存放整型变量
		 int c6 = 97;
		 //char c7 = c6;//错误用法
		 char c8 = (char)c6;
		 System.out.println("c8="+c8);//输出97对应的字符（a）

		 System.out.println(c1);
		 System.out.println((int)c1);//说明：字符要输出对应数字时要用强制类型转换（int）
		 System.out.println(c2);
		 System.out.println(c3);
		 System.out.println(c4);
		 System.out.println(c5);

		 //说明：char类型可以进行运算
		 System.out.println("运算结果");
		 System.out.println('a'+3);//100://不同类型进行运算，表达式结果自动转为操作数中最大的类型
		 

		 //boolean 布尔类型，只能用true和false赋值，不能用0和非零数进行代替

		 boolean ispass = true;

		 if(ispass = true){
		 	System.out.println("考试通过！");
		 }else{
		 	System.out.println("考试未通过！");
		 }

		 // 自动类型转换(低精度往高精度)
		 // char->int->long->float->double
		 // byte->short->int->long->float->double
		 //byte、short和char之间不会发生自动转换
		 //byte a1 = 10000000000;
		 byte a2 = 10;
		 //不同类型进行运算，表达式结果自动转为操作数中最大的类型

		 //byte、short、char进行运算结果为int类型
		 //byte、short、char在进行运算时当做int类型处理
		 byte b1 = 1;
		 short s1 = 2;
		 // short s3 = b1 + s1;//错误，运算结果为int类型
		 int s3 = b1 + s1;
		 int s4 = b1 + a2;

		 //boolean类型不可参与运算

		 //强制类型转换，eg:i = (int)1.999;
		 int i = (int)1.9;//精度损失
		 System.out.println("i="+i);

		 int i2 = 2000;
		 byte b2 = (byte)i2;//数据溢出
		 System.out.println("b2="+b2);

		 //强制类型转换使用说明
		 //int a3 = (int)1.5*4+1.5*6;//错误使用
		 int a3 = (int)(1.5*4+1.5*6);//正确使用

		 //练习
		 short x1 = 12;
		 short x2 = 2;
		 
		 //x1 = x1-9;//(x1-9)结果为int型
		 //x1 = x1 - x2;//(x1-x2)结果为int型




	}
}