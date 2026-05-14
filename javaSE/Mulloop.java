//多重循环
import java.util.Scanner;
public class Mulloop{
	public static void main(String[] args) {

		int n = 2;
		int m = 2;

		Scanner myScanner = new Scanner(System.in);
		double score;
		double sumScore = 0;
		double allSumScore = 0;
		int count = 0;
		int allCount = 0;
		for(int class1 = 1; class1 <= n; class1++){
			for(int stu = 1;stu <= m; stu++){
				System.out.println("请输入" + class1 + "班，第" + stu +
					"个同学的成绩：");
				score = myScanner.nextDouble();
				count = score >= 60.0 ? ++count : count;//注意这里不能用count++
				sumScore += score;

			}
			allSumScore += sumScore;
			double avg = sumScore / (m);
			System.out.println(class1 + "班的及格人数为" + count);
			System.out.println("第" + class1 + "班的平均成绩为" + avg);
			sumScore = 0;
			allCount += count;
			count = 0;
		}
		double avg = allSumScore / (n * m);
		System.out.println("所有班级的平均成绩为" + avg);
		System.out.println("所有班级的及格人数为" + allCount);


		//
		int num1 ;
		int num2 ; 
		for(num1 = 1; num1 <= 9; num1++){//外行内列
			for(num2 = 1; num2 <= num1; num2++){

				int result = num1*num2;
				System.out.print(num1 + "×" + num2 + "=" + result);
				System.out.print("\t");
			}
			System.out.print("\n");

		}

	}

}