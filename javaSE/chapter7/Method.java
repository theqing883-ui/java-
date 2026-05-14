// 成员方法介绍
public class Method {
	public static void main(String[] args) {
		// 方法使用
		// 1. 方法写好后，如果不去调用，就不会输出
		// 2. 先创建一个对象，再调用
		Person p1 = new Person();
		p1.speak();// 调用方法
		p1.ca101();
		p1.ca102(5); // 调用ca102 同时传输5给n
		int sum;
		sum = p1.getSum(10,20);
		System.out.println("getSum计算结果：" + sum);

	}
}

class Person {
	// 属性(成员)
	String name;
	int age;
	// 方法(成员方法)
	// 添speak 成员方法，输出"我是一个好人"
	// 1.public 表示方法是功能公开的
	// 2.void表示方法没有返回值
	// 3.speak() speak 方法名，() 形参列表(这里没有)
	// {} 方法体
	public void speak() {
		System.out.println("我是一个好人！");
	}

	// 添加ca101 的方法，计算1+...+1000
	public void ca101() {
		int sum = 0;
		for(int i = 1; i <= 1000; i++){
			sum += i;
		}
		System.out.println("ca101计算结果：" + sum);
	}
	// 添加ca102 的方法，接收一个n，计算1+...+n
	// 1. (int n) 表示形参列表，表示当前有一个形参n;
	public void ca102(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++){
			sum += i;
		}
		System.out.println("ca102计算结果：" + sum);
	}

	// 添加方法getsum,计算接收到的两个数的和
	// 1.public 表示方法是功能公开的
	// 2.int 表示方法执行后会返回一个 int 值
	// (int a, int b) 表示可以接收两个 int 类型的形参
	// return res; 将res的值返回
	public int getSum(int a, int b) {// 有多少个形参就写多少个数据类型
		int res = a  + b;
		return res;
	}

}