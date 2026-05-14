// 11

public class Homework11 {
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.test1();
		// System.out.println()的()中要有返回值
		// System.out.println(t1.method1(1.2,1)); 
	}
}

class Test {
	
	public double method(double num1, double num2){
		return(num1 + num2);
	}
	// public double method(double num1, int num2){
	// 	return(num1 + num2);
	// }
	public void test1(){
		System.out.println(method(method(10.0,20.0),100));
	}
	public void method1(double num1, int num2){
		
	}
}