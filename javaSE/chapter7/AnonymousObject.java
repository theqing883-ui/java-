// Anonymous object[匿名对象]
public class AnonymousObject{
	public static void main(String[] args) {
		// 1.new Test();表示创建一个匿名对象
		// 2.一个匿名对象只能使用一回，使用后就被销毁
		// 3.new Test().show();表示调用匿名对象的show()方法
		new Test().show();
	}
}

class Test {
	int count = 9;
	public void show(){
		System.out.println(this.count);
	}
}