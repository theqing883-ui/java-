// 成员方法介绍


//  1)一个方法最多有一个返回值 [思考，如何返回多个结果 返回数组 ]
//  2) 返回类型可以为任意类型，包含基本类型或引用类型(数组，对象)

public class MethodDetail {
	// main 方法
	public static void main(String[] args) {
		AA a = new AA();
		short d = 1;
		int[] res = a.GetSumDdd(2,d);// 实参
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + "\t");
		}
		String D = "3";
		int f = Integer.parseInt(D);
	}
}

class AA {
	public int[] GetSumDdd(int a,int b) {
		int[] res = new int[2];
		res[0] = a + b;
		res[1] = a - b;
		return res;
	}
}

// 3) 如果方法要求有返回数据类型，则方法体中最后的执行语句必须为 return 值;
//  	而且要求返回值类型必须和return的值类型一致或兼容
class AB {
	public double GetSumDdd1(int a) {
		int res;
		res = a + 1;
		return res;
		// 方法不可以嵌套定义
		// public void GetSumDdd2(int a) {
		// int res;
		// res = a + 1;
		// return ;
		// }
	}
}

// 4) 如果方法是void，则方法体中可以没有return语句，或者 只写 return;
class AC {
	public void GetSumDdd2(int a) {
		int res;
		res = a + 1;
		return ;
	}
}