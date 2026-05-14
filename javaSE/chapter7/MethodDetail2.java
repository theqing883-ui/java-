public class MethodDetail2 {
	// main 方法
	public static void main(String[] args) {
    A ad = new A();
    ad.SayOk();
    ad.Sayhi();
	}
}

 class A {
 	// 同一个类里面的方法直接调用即可
 	public void print(int n) {
 		System.out.println("输出为：" + n);
 	}
 	public void SayOk() {
 		print(10);
 		System.out.println("继续执行sayok~~");

 	}
 	public void Sayhi() {
 		SayOk();
 		B hello = new B();
 		hello.hi();
 		System.out.println("继续执行sayhi~~");

 	}
 }

 class B {
 	// 同一个类里面的方法直接调用即可
 	public void hi() {
 		System.out.println("B类里面的hi方法被调用");
 	}
 }