// 构造器练习
public class ConstructorExercise {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(10086, "yidong");
		/** Person p2 = new Person(10086, "yidong");的执行流程
		 * 1.首先在方法区加载Person,只会加载一次
		 * 2.在堆分配空间用于存储age 和 name, 
		 * 3.完成初始化【3.1 给所有成员属于赋予默认值 age = 0,name = null 
		 *   3.2 显示初始化 age = 90,name = null 3.3 构造器初始化 
		 * age = pAge; name = pName;】
		 * 4.把这个对象在堆中的首地址赋值给p2(p2是对象名)
		 * */
		System.out.println("p1的信息：\n" + p1.age + "  " + p1.name);
		System.out.println("p2的信息：\n" + p2.age + "  " + p2.name);
	}
}

/**
 * 第一个无参构造器：利用构造器设置所有人的age属性初始值都为18
 * 第二个带pName和pAge两个参数的构造器：使得每次创建Person对象的同时
 * 初始化对象的age属性值和name属性值。分别使用不同的构造器，创建对象.
*/


class Person {
	int age = 90;
	String name;// 默认值null

	public Person(){
		age = 18;
	}

	public Person(int pAge, String pName){
		age = pAge;
		name = pName;
	}
}