//while循环
import java.util.Scanner;
public class WhileCycle{
	public static void main(String[] args) {
		int i = 1;//循环变量初始化
		while(i <= 10){//循环条件
			System.out.println("i=" + i);//执行语句
			i++;//循环变量迭代
		}
		//练习
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入0~100的一个数:");
		double endNum = myScanner.nextDouble();
		System.out.println("请输入0~"+ endNum + "的一个数:");
		double startNum = myScanner.nextDouble();
		while(startNum <= endNum){
			if(startNum % 3 == 0){
				System.out.println("num=" + startNum);
			}
			startNum++;
		}



		System.out.println("请输入40~200的一个数:");
		double endNum2 = myScanner.nextDouble();
		System.out.println("请输入40~"+ endNum2 + "的一个数:");
		double startNum2 = myScanner.nextDouble();
		while(startNum2 <= endNum2){
			if(startNum2 % 2 == 0){
				startNum2++;
				System.out.println("num=" + startNum2);
			}
			
		}
	}
}