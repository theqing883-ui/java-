// this 关键字
/*
  1.this 关键字可以用来访问本类的属性、方法、构造器
  2.this 用来区分当 前类的不同对象的属性 和 局部变量
  3.访问成员方法的语法：this.方法名(参数列表);
  4.访问构造器的语法：this(参数列表);
  	4.1 注意这种方式只能在构造器里面使用
  	4.2 注意如果采用这种方式在构造器1访问构造器2，那这条语句必须放在构造器1
  	的第一条语句
  5.this 不能再此类定义的外部使用，只能在类定义的方法中使用；
*/
public class This01 {
	public static void main(String[] args) {
		T t1 = new T();
		t1.f2();
	}
}

class T {
	public T(){
		this("milan");
		System.out.println("T()构造器");
		// 希望在T()中访问T(String name)

	}
	public T(String name){
		System.out.println("T(String name)构造器");
	}

	public void f1(){
		System.out.println("f1方法");
	}

	public void f2(){
		System.out.println("f2方法");
		// 在f2中调用f1方式1
		f1();
		// 在f2中调用f1方式2
		this.f1();
	}
}