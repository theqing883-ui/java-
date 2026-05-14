// switch介绍

//1.switch（表达式）中表达式的返回值必须是：(byte，short,int,char,enum[枚举],String)
//2.case 子句中的值必须是常量或者常量表达式，不能是变量；
//3.switch可以没有default语句，推荐写上
import java.util.Scanner;

public class Switch1{
	public static void main(String[] args) {
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入a~f的一个字母：");
		char character;
		 // 等效String input = myscanner.next();
         //     character = input.charAt(0);
		while(true){
			character = myscanner.next().charAt(0);
			if(character == 'e'){
				System.out.println("已退出！");
				break;
			}

			switch(character){
				case 'a':{
					System.out.println("星期一\n继续输入或者输入e退出");
					break;
				}
				case 'b':{
					System.out.println("星期二\n继续输入或者输入e退出");
					break;
				}
				case 'c':{
					System.out.println("星期三\n继续输入或者输入e退出");
					break;
				}
				case 'd':{
					System.out.println("星期四\n继续输入或者输入e退出");
					break;
				}
				case 'e':{
					System.out.println("星期五\n继续输入或者输入e退出");
					break;
				}
				case 'f':{
					System.out.println("星期六\n继续输入或者输入e退出");
					break;
				}
				case 'g':{
					System.out.println("星期天\n继续输入或者输入e退出");
					break;
				}
				default://switch可以没有default语句，推荐写上
					System.out.println("输入有误！请输入a~f的一个字母或者输入e退出：");
					character = myscanner.next().charAt(0);
					break;
			}
		}
	}
}