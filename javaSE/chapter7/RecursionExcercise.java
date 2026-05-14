// 递归练习
import java.util.Scanner;//注意分号
public class RecursionExcercise {
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入整数n:");
		int n = myScanner.nextInt();
		Tool myTool = new Tool();
		int res = myTool.Fibonacci(n);
		System.out.println("菲波拉契数列的第" + n + "个数是：\n" + res);

		int R = 1;
		System.out.println("请输入整数n:");
		int N = myScanner.nextInt();		
		int total = myTool.Monky(N,R);
		System.out.println("最初有" + total + "个桃子");
		int total2 = myTool.peach(N);
		System.out.println("最初有" + total2 + "个桃子");



	}
}




class Tool {
// 请使用递归的方式求出斐波那契数1,1,2,3,5,8,13...给你一个整数n，
// 求出它的值是多
// 思路：
// 1、n = 1、2时，res = 1;
// 2、n > 2时，res(n) = res(n-1) + res(n - 2)
	public int Fibonacci(int n){
		if(n == 1 || n == 2){
			return(1);
		}else{
			return(Fibonacci(n-1)+Fibonacci(n-2));
		}
	}
	
/*
	猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
	以后每天猴子都吃其中的一半，然后再多吃一个。当到第10天时，
	想再吃时（即还没吃），发现只有1个桃子了。问题：最初共多少个桃子？
	思路：
	1、day = 10 tao = 1;
	2、day = 9 tao = (1+1)*2 = 4;
	2、day = 8 tao = (4 + 1)*2 = 10;
*/
	public int Monky(int n, int total){
		if(n == 1){
			return(total);
		}else{
			n--;
			return(Monky(n,(total + 1)*2));
		}
	}
	// 或者
	public int peach(int n){
		if(n == 10){
			return 1;
		}else{
			return  (peach(n + 1) + 1) * 2;
		}
	}
}