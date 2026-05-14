// 11

public class Homework12 {
	public static void main(String[] args) {
		Employee myEmployee1 = new Employee("经理","20000");
		System.out.println("员工1 "+ myEmployee1.position + "\t" + myEmployee1.salary);
		Employee myEmployee2 = new Employee("zhong","男","25");
		System.out.println("员工2 "+ myEmployee2.name + "\t" + myEmployee2.gender 
			+ "\t" + myEmployee2.age);
		Employee myEmployee3 = new Employee("zhong","男","25","经理","20000");
		System.out.println("员工3 "+ myEmployee3.position + "\t" + myEmployee3.salary
		 + "\t" + myEmployee3.name + "\t" + myEmployee3.gender + "\t" + myEmployee3.age);
		Employee myEmployee4 = new Employee("经理");
	}
}

class Employee {
	String name;
	char gender;
	int age;
	String position;
	double salary;

	public Employee(String... information){
		if(information.length == 2){
			this.position = information[0];
			this.salary = Double.parseDouble(information[1]);
		}else if(information.length == 3){
			this.name = information[0];
			this.gender = information[1].charAt(0);
			this.age = Integer.parseInt(information[2]);
		}else if(information.length == 5){
			this.name = information[0];
			this.gender = information[1].charAt(0);
			this.age = Integer.parseInt(information[2]);
			this.position = information[3];
			this.salary = Double.parseDouble(information[4]);
		}else{
			System.out.println("输入有误");
		}
	}

	// 职位，薪水
	public Employee(String job, double sal) {
	    this.position = job;
	    this.salary = sal;
	}

	// 名字，性别，年龄
	public Employee(String name, char gender, int age) {
	    this.name = name;
	    this.gender = gender;
	    this.age = age;
	}

	// 名字，性别，年龄，职位，薪水
	public Employee(String job, double sal, String name, char gender, int age) {
	   	this(name, gender, age);
	   	// 在Java中，构造器调用通常用this()实现，必须放在第一行，
		// 并且只能有一个构造器调用。
	    this.position = job;
	    this.salary = sal;
	}

}

