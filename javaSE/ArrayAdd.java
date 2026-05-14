// 数组扩容
import java.util.Scanner;
public class ArrayAdd {
	public static void main(String[] args) {
		/*思路分析
		1.定义初始数组int[] arr = {1,2,3}//下标0-2
		2.定义一个新的数组int[] arrNew = new int[arr.length + 1];
		3.遍历 arr 数组，依次将 arr 的元素拷贝到 arrNew 数组
		4.将 4 赋给arrNew[arrNew.length-1] = 4;把 4 赋给 arrNew 最后一个元素
		5.让 arr 指向 arrNew ；arr = arrNew;那么原来 arr 数组就被销毁
		*/

		
		int[] array1 = {1, 2, 3};
		Scanner myScanner = new Scanner(System.in);

		int[] arrayNew = new int[array1.length+1];
		for(int i = 0; i < array1.length; i++){
			arrayNew[i] = array1[i];
		}
		arrayNew[array1.length] = 4;
		array1 = arrayNew; 
		for(int i = 0; i < array1.length; i++){
			System.out.println(array1[i]);
		}

		System.out.println("是否继续添加(Y/N):");
		char flag = myScanner.next().charAt(0);
		while(flag == 'Y'){
			int[] arrayNew2 = new int[array1.length+1];
			for(int i = 0; i < array1.length; i++){
				arrayNew2[i] = array1[i];
			}
			System.out.println("请输入要添加的整数:");
			int num = myScanner.nextInt();
			arrayNew2[array1.length] = num;
			array1 = arrayNew2; 
			System.out.println("是否继续添加(Y/N):");
			flag = myScanner.next().charAt(0);		
		}
		System.out.println("已退出，新的数组为:");

		for(int i = 0; i < array1.length; i++){
			System.out.print(array1[i] + " ");
		}
	}
} 