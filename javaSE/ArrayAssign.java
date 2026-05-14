// 数组赋值机制
public class ArrayAssign{
	public static void main(String[] args) {
		// 基本数据类型的赋值机制
		int n1 = 10;
		int n2 = n1;
		n2 = 80;//n2变化不影响n1（值传递）
		System.out.println(n1);
		System.out.println(n2);

		//数组
		int[] arr1 = {1, 2, 3};
		int[] arr2 = arr1;//传递的地址，arr2变化影响arr1（引用传递）
		arr2[0] = 10;
		int[] arr3 = new int[arr1.length];

		for(int i = 0; i < arr1.length; i++){
			System.out.println(arr1[i]);
			arr3[i] = arr1[i];
		}
		arr3[0] = 20;
		for(int i = 0; i < arr1.length; i++){
			System.out.println(arr3[i]); 
		}
	}
}