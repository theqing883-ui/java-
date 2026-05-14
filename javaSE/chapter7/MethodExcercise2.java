public class MethodExcercise2 {
	// main 方法
	public static void main(String[] args){
		Person Person1 = new Person();
		Person1.name = "XXQ";
		Person1.age = 25;
		Tool myTool = new Tool();
		Person Person2 = myTool.CopyPerson(Person1);
		// Person Person2 = new Person();
		// Person2 = Person1.CopyPerson(Person1);
		System.out.println("Person1的属性\n name:" + Person1.name + "\tage:" + Person1.age);
		System.out.println("Person2的属性\n name:" + Person1.name + "\tage:" + Person1.age);
		Person1.name = "hsq";
		Person1.age = 25;
		Person2.name = "TTT";
		Person2.age = 24;
		System.out.println("改变Person2后，Person1的属性\n name:" + Person1.name + 
			"\tage:" + Person1.age);
		System.out.println("改变Person2后，Person2的属性\n name:" + Person2.name + 
			"\tage:" + Person2.age);


	}
}

class Person {
	String name;
	int age;
}

class Tool {
	// 编写一个方法copyPerson，可以复制一个Person对象，返回复制的对象。克隆对象，
	// 注意要求得到新对象和原来的对象是两个独立的对象，只是他们的属性相同
	public Person CopyPerson(Person Person1){
		Person Person2 = new Person();
		Person2.name = Person1.name;
		Person2.age = Person1.age;
		// Person2 = Person1;// 错误

		return Person2;
	}
}


