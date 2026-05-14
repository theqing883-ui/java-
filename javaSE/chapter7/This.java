// this：java虚拟机会给每个对象分配 this,代表当前对象。
/*
   1.可以理解为指向对象自己的一个对象名，谁调用就指向谁
*/
public class This {
 	//编写一个main方法
	public static void main(String[] args) {
	Dog dog1 = new Dog("大壮", 3);
	System.out.println("dog1的hashcode:" + dog1.hashCode());
	dog1.info();

	}
}
 class Dog{ //类
	String name;
	int age;

/*
hashCode():针对不同对象会返回一个不同的整数，这个整数是根据转换而来
*/


/*
如果我们构造器的形参，能够直接写成属性名，就更好了
但是出现了一个问题，根据变量的作用域原则
构造器的name 是局部变量，而不是属性
构造器的age 是局部变量，而不是属性
==>引出this关键字来解决
*/
	public Dog(String name,int age){//构造器
		this.name = name;
		this.age = age;
		// name = name;
		// age = age;
		System.out.println("this的hashcode:" + this.hashCode());
	}
	public void info(){//成员方法,输出属性x信息
		System.out.println("this的hashcode:" + this.hashCode());
		System.out.println(name + "\t" + age + "\t");
	}

 }