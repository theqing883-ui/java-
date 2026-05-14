//DoWhile 介绍
//与for循环和while循环不同（循环体可能一次也不执行），do...while的循环体至少循环一次
public class DoWhile{
	public static void main(String[] args) {
		//实例
		int i = 0;
		do{
			System.out.println("Battle！");
			i++;
		}while(i <= 3);//这个分号容易忘记

		int j  = 1;
		int sum = 0;
		do{
			sum += j;
			System.out.println(j);
			j++;
		}while(j <= 100);//这个分号容易忘记
		System.out.println("总和为：" + sum);



		int num1  = 1;
		int num2 = 200;
		int count = 0;
		do{
			if((num1 % 5 == 0) &&(num1 % 3 != 0)){
				System.out.println(num1);
				count++;
			}
		
			num1++;
		}while(num1 <= num2);//这个分号容易忘记
		System.out.println("共" + count + "个。");
	}
}