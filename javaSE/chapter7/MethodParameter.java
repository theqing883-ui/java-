//  方法传参机制
public class MethodParameter {
	// main 方法
	public static void main(String[] args){
		// 基本数据类型传参机制
		int a = 10;
		int b = 20;
		AA myAA = new AA();
		myAA.swap(a,b);
		System.out.println("交换后main中的a,b：" + a + b);

		// 引用数据类型传参机制
		int[] arr2 = {1,1,1};
		System.out.println("未调用方法前");
		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		myAA.test100(arr2);
		System.out.println("\n调用方法后main中：");
		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		AA Person = new AA();
		Person.age = 30;
		Person.sal = 45.5f;
		System.out.println("未调用方法前，age = " + Person.age + "\tsal = " + Person.sal);
		myAA.change(Person);
		System.out.println("main中调用方法后，age = " + Person.age + "\tsal = " + Person.sal);



	}
}

class AA {
	int age;
	float sal;
	// 基本数据类型传参机制
	public void swap(int a, int b){
		System.out.println("交换前a,b：" + a + b);
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("交换后a,b：" + a + b);
	}
	// 引用数据类型传参机制[数组]
	public void test100(int[] arr) {
		arr[0] = 100;
		System.out.println("\n修改后方法中");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	// 引用数据类型传参机制[对象]
	public void change(AA Person){
		Person.age = 40;
		Person.sal = 60.0f;
	}

}