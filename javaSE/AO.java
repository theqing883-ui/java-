// 算术运算符

public class AO{
	public static void main(String[] args) {
		
		System.out.println(10/4);//2
		System.out.println(10.0/4);//2.5
		double d1 = 10/4;
		System.out.println(d1);//2.0

		//取余%，结果和被取的数同号
		System.out.println(10%3);//1
		System.out.println(-10%3);//-1
		System.out.println(10%-3);//1
		System.out.println(-10%-3);//-1
		
		//自增++或自减--

		int i = 10;
		int i1 = 10;
		int i2 = 10;
		i++;
		System.out.println(i);//1
		int a = 1 + i1++;
		int b = 1 + ++i2; 
		
		System.out.println(a);//1
		System.out.println(b);//1

		int c = 1;
		c = c++;//(1)temp = i;(2)i=1+i;(3)i=temp
		System.out.println(c);//1


		int day = 59;
		int w = 7;
		int week = day/w;
		int s = 59%w;
		System.out.println("合计" + week + "星期，零" + s + "天。"); 
		//1.0默认为double
		float hc = 234.5f;
		float k  = 5f/9;
		float cc = (hc-100)*k;
		System.out.println("摄氏温度为" + cc + "。"); 

	}
}