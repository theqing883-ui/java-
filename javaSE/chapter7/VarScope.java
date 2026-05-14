// 作用域
public class VarScope {
	public static void main(String[] args) {
		Cat myCat = new Cat();
		myCat.play();// sumAge在条语句结束后就释放了
	}
}

// 字符串都在常量池

// 在一个类中
/*
1.全局变量：成员属性
2.局部变量：这个类中除了成员属性的其他变量，不止成员方法中的变量
3.全局变量【成员属性】可以不赋值，可以直接使用，因为有默认值
4.局部变量【成员属性】必须赋值后才能使用，因为没有有默认值
5.全局变量、局部变量、不同方法里面的方法里面，可以重名，
  使用时遵守就近原则
6.全局变量既可以在本类中直接调用，也可以在其他类中通过对象调用
7.局部变量只能在本类的本方法中使用
8.全局变量可以加修饰符
9.局部变量不可以加修饰符
*/

class Cat {
	int age = 1;// 全局变量【针对Cat这个类，作用域为这个Cat类】（成员属性），默认为0	

	public void play(){
		int age = 2;
		int sumAge;// 局部变量【作用域为这个方法】
		System.out.println(age);
		// System.out.println(sumAge);

	}
}