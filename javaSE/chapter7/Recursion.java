public class Recursion {
	// main 方法
	public static void main(String[] args){
		T myT = new T();
		myT.test(4);
		System.out.println("n的阶乘：" + myT.Factorial(5));

	}
}

class T {
	public void test(int n){
		if(n > 2){
			test(n-1);// 递归返回来时，返回到此一步的末尾(不会再执行这一步，执行此一步的下一条)
		}
		System.out.println("n=" + n);
	}

	public int Factorial(int n){
		if( n == 1){
			return n;
		}else{
			return Factorial(n-1)*n;
		}
	}
}