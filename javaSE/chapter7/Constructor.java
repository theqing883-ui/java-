// 构造器/构造方法
/*
基本语法
	[修饰符] 方法名(形参列表){
	方法体;
	}
// 构造方法又叫构造器(constructor)，是类的一种特殊的方法，
   它的主要作用是完成对新对象的【初始化】，在调用构造器之前这个
   被初始化的对象已经存在。
1) 构造器的修饰符可以默认， 也可以是public protected private
2) 构造器没有返回值 //void也不要写
3) 方法名和类名字必须一样
4) 参数列表 和 成员方法一样的规则
5) 构造器的调用, 由系统完成

6.一个类可以有多个构造器，但是构造器之间的形参不同,即构造器的重载
7.如果程序员没有定义构造器，系统会自动生成一个默认无参构造器(也叫
默认构造器),比如 Dog(){}; //反编译指令 javap
8.一个类中程序员一旦定义了自己的构造器，默认的构造器就被覆盖了，除非自己再
声明一下 Dog(){} ，否则 Dog dog1 = new Dog(); 会报错

9.在Java中，构造器调用this()实现，子类调用父类构造器时用super()实现, 都必须放在第一行，
	并且只能有一个构造器调用。
*/
public class Constructor{
	public static void main(String[] args) {
		Person p1 = new Person("Smith", 80);// 构造器1
		Person p2 = new Person("Smith");// 构造器2
		System.out.println("名字： " + p1.name + "  年龄: " + p1.age);
		System.out.println("名字： " + p2.name + "  年龄: " + p2.age);
		Dog dog1 = new Dog();
	}
}


class Dog {

	/*
	7.如果程序员没有定义构造器，系统会自动生成一个默认无参构造器(也叫
	默认构造器),比如 Dog(){}; //反编译指令 javap

	默认构造器
	Dog(){
	
	}
	*/
	// 自己定义的构造器
	public Dog(int n){
 
	}
	// 声明的默认构造器
	Dog(){}
	
}




class Person {
	int  age;
	String name;
	// 构造器1
	public Person(String pName, int pAge){
		System.out.println("构造器被使用~~~~");
		name = pName;
		age = pAge;
	}
	// 构造器2
	public Person(String pName){

		System.out.println("构造器被使用~~~~");
		name = pName;
	}
}