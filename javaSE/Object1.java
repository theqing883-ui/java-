// 类与对象
public class Object1 {
	//main 方法
	public static void main(String[] args) {
		
 		// 1.先声明再创建
 		Cat p2;// 声明对象
 		p2 = new Cat();// 分配空间，创建对象

 		// 1.2.直接创建
 		// 创建Person对象
		// p1 是对象名
		// new Person() 创建的对象空间(数据)才是真正的对象
		Person p1 = new Person();

		//对象的属性默认值，遵守数组规则:
 		//int 0，short 0, byte 0, long 0, float 0.0,double 0.0，char \u0000，boolean false，String null
		System.out.println("\n 当前这个人的信息");
 		System.out.println("age=" + p1.age + " name=" + p1.name) ;

 		// 2.访问属性
 		// 对象名.属性;



	}
}

class Person {
	// 属性
	String name;
	int age;
	String color;
}
