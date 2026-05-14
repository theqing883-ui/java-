//Switch2
import java.util.Scanner;
public class Switch2{
	public static void main(String[] args) {
		Scanner myscanner = new Scanner(System.in);
		char character;
		System.out.println("请输入小写字母(a~e):");
		String input = myscanner.next();
		character = input.charAt(0);

		switch(character){
			case 'a':
				System.out.println("A");
				break;
			case 'b':
				System.out.println("B");
				break;
			case 'c':
				System.out.println("C");
				break;
			case 'd':
				System.out.println("D");
				break;
			case 'e':
				System.out.println("E");
				break;
			default:
				System.out.println("other");
				break;

		}

		System.out.println("请输入成绩(0~100):");
		double score = myscanner.nextDouble();

		if((score <= 100) && (score >= 0)){

			switch((int)score >= 60 ? 1 : 2){//(int)score/60
				case 1:
					System.out.println("成绩合格！");
					break;
				case 2:
					System.out.println("成绩不合格！");
					break;
				default:
					System.out.println("感谢使用！");
					break;
			}

		}else{
			System.out.println("输入不合理！");
		}


		System.out.println("请输入月份:");
		int month = myscanner.nextInt();
		switch(month){
				case 3:					
				case 4:					
				case 5:
					System.out.println("春季！");
					break;
				case 6:					
				case 7:					
				case 8:
					System.out.println("夏季！");
					break;
				case 9:					
				case 10:			
				case 11:
					System.out.println("秋季！");
					break;
				case 12:
				case 1:
				case 2:
					System.out.println("冬季！");
					break;
				default:
					System.out.println("输入有误！");
					break;
			}



	}
}