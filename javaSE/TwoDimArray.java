// 二维数组
// 1.初始化   array.length 行数 array[i].length 列数	注意：每个一维数组(每行)的	元素个数(列数)可以不一样
// 1.1动态初始化：类型[][] 数组名 = new 类型[行数][列数] 或 类型 数组名[][] = new 类型[行数][列数]
// String strs[] = new String[]{"a","b"};也可以
// 1.2动态初始化(先声明，后赋值) :类型[][] 数组名; 数组名 = new 类型[行数][列数] 或 类型 数组名[][]; 数组名 = new 类型[行数][列数]
// 1.3动态初始化，列数不一致
// 1.4 ，类型[][] 数组名 = {{...},{...}...}; 或 类型 数组名[][] = {{...},{...}...};
// 类型[] 数组名[] = {{}};也行
public class TwoDimArray {
	// main 方法
	public static void main(String[] args) {
		// 1.1动态初始化：类型[][] 数组名 = new 类型[行数][列数]
		// int[][]  array1 = new int[4][4];
		int[][]  array1;
		array1 = new int[4][4];
		// 赋值
		for(int i = 0; i < array1.length; i++){
			for(int j = 0; j < array1[i].length; j++){
				array1[i][j] = i * j;
			}
		}
		// 输出
		for(int i = 0; i < array1.length; i++){
			for(int j = 0; j < array1[i].length; j++){
				System.out.print(array1[i][j] + " ");
			}
			System.out.print("\n");
		}

		 /* 1.3动态初始化，列数不一致
			看一个需求：动态创建下面二维数组，并输出
			i = 0: 1
			i = 1: 2 2
			i = 2: 3 3 3
			一个有三个一维数组, 每个一维数组的元素是不一样的
		*/
		// 初始化
		int[][] arr = new int[3][];// 创建二维数组，但是未给一维数组分配空间
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[i + 1]; // 给一维数组分配空间
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = i+1;
			}
		}
		// 输出
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}



		// 静态初始化
		int[][] array = {{0,0},{0,0,1,0,0,0},
					{0,2,0,3,0,0},{0,0,0,0,0,0}};
		//array.length 行数
		//array[i].length 列数			
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 6; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.print("\n");
		}


		String strs[] = new String[]{"a","b"};
	}
}