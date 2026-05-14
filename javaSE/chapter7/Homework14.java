// 14
import java.util.Scanner;
public class Homework14 {
	public static void main(String[] args) {
		Play p1 = new Play();
		p1.start();
	}
}
/*
1.电脑随机产生0,1,2，(int)Math.random() * 3;
2.tom赢的方式：computer		Tom
				石头0		布2
				剪刀1		石头0
				布2			剪刀1	

// 数组调用 farm[0]
*/

class Play {
	String[] form = {"石头","剪刀","布"};
	public void start(){
		int count = 0;
		Scanner myScanner = new Scanner(System.in);
		char flag;
		do{ 
			int computer = (int)(Math.random() * 3);
			System.out.println("电脑\tTom");
			System.out.println("请输入Tom出石头(0)、剪刀(1)、布(2)：");
			int tomNum = myScanner.nextInt();
			if((computer == 0 && tomNum == 2) ||
			 (computer == 1 && tomNum == 0) ||
			 (computer == 2 && tomNum == 1)){
				System.out.println(form[computer] + "\t" + 
					form[tomNum] + "\tTom赢");
				count++;
			}else if(computer == tomNum){
				System.out.println(form[computer] + "\t" + 
					form[tomNum] + "\t平局");
			}else if(tomNum != 0 && tomNum != 1 && tomNum != 2){
				System.out.println("输入有误");
			}else{
				System.out.println(form[computer] + "\t" + 
					form[tomNum] + "\tTom输");
			}
			System.out.println("是否继续Y/N:");
			flag = myScanner.next().charAt(0);
		}while(flag == 'Y');
		System.out.println("Tom赢了" + count + "回");

	}
}