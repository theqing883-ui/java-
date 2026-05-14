// 可变参数：在同一个类中把同名同功能但是参数不同的方法，封装为一个方法

/*
	1.int... 表示接收的是可变参数，类型int
	2.使用可变参数时，可以当做数组来用，即nums可以当做数组。
	3.可变参数的实参类型可以为数组
	3.可变参数可以和普通类型的参放在一起，但是要保证可变参数放在最后
	4.一个形参列表中只能有一个可变参数
*/

public class VarParameter {
	public static void main(String[] args) {
		Tool myTool = new Tool();
		myTool.sum();
		int res = myTool.sum(1,2,3,4,5);
		int[] array = {1,2,3,4,5};
		int res2 = myTool.sum(array);
		int res3 = myTool.sum1(10,array);
		System.out.println("1,2,3,4,5和为" + res);
		System.out.println("array和为" + res2);
		System.out.println("array与10和为" + res3);
		


	}
}

class Tool{
	// 1.int... 表示接收的是可变参数，类型int
	// 2.使用可变参数时，可以当做数组来用，即nums可以当做数组。
	// 3.对nums 遍历求和
	public int sum(int... nums){// 有个空格
		System.out.println("接收的参数个数：" + nums.length);
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			res += nums[i];
		}
		return res;
	}

	public int sum1(int n, int... nums){
		System.out.println("接收的参数个数：" + nums.length);
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			res += nums[i];
		}
		res += n;
		return res;
	}
}