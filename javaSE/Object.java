// 类与对象
// 方便管理属性与行为
// 定义一个猫类
class Cat {
	String name;
	int age;
	String color;
}

public class Object {
	//main 方法
	public static void main(String[] args) {
	// 创建一个猫对象
	Cat cat1 = new Cat();
	cat1.name = "小白";
	cat1.age = 3;
	cat1.color = "蓝色";

	// 访问对象属性
	System.out.println("这只猫的信息是：\n" + "名字\t" + "年龄\t" + "颜色\n" +
						 cat1.name + "\t" + cat1.age +"\t" + cat1.color);
	}
}