// this 练习

/*
定义Person类，里面有name、age属性，并提供compareTo比较方法，
用于判断是否和另一个人相等，提供测试类TestPerson
用于测试,名字和年龄完全一样，就返回true,否则返回false
*/
import java.util.Scanner;
public class ThisExercise {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.println("请输入p1的名字：");
		String p1Name = myScanner.nextLine();
		System.out.println("请输入p1的年龄：");
		int p1Age = myScanner.nextInt();


		// 紧接着使用 nextLine() 时，
		// nextLine() 会读取之前输入数字时按下的回车键，导致跳过输入
		myScanner.nextLine();

		System.out.println("请输入p2的名字：");
		String p2Name = myScanner.nextLine();
		System.out.println("请输入p2的年龄：");
		int p2Age = myScanner.nextInt();

		Person p1 = new Person(p1Age, p1Name);
		Person p2 = new Person(p2Age, p2Name);
		boolean flag = p1.compareTo(p2);

		if(flag){
			System.out.println("p1和p2信息一样");
		}else{
			System.out.println("p1和p2信息不一样");
		}
	}
}

class Person {
	int age;
	String name;
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}

	public boolean compareTo(Person p1){//比较当前对象和传入对象的信息
		if(this.age == age && this.name.equals(p1.name)){
			return true;
		}else{
			return false;
		}
	}
}

