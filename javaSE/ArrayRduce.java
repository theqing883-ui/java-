//数组缩减
import java.util.Scanner;
public class ArrayRduce {
	//main方法
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		Scanner myScanner = new Scanner(System.in);
		do{
			if(array.length == 1){
				System.out.println("数组仅有一个元素，无法再缩减。");
				break;
			}
			int[] arrayNew = new int[array.length-1];
			for(int i = 0; i < arrayNew.length; i++){
				arrayNew[i] = array[i]; 
			}
			array = arrayNew;
			System.out.println("缩减后的数组为：");
			for(int i = 0; i < arrayNew.length; i++){
				System.out.print(array[i] + "\t");
			}
			System.out.print("\n");
			if(array.length == 1){
				System.out.println("数组仅有一个元素，无法再缩减。");
				break;
			}
			System.out.println("是否继续缩减(Y/N)：");
			char flag = myScanner.next().charAt(0);
			if(flag == 'N'){
				System.out.println("退出缩减");
				break;
			}
		}while(true);
	}
}