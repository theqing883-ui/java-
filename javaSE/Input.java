//用户输入

import java.util.Scanner;//表示把java.util包下的Scanner类导入，Scanner表示简单的文本扫描器
public class Input{
	public static void main(String[] args) {
		//1.导入Scanner类所在的包
		//2.创建 Scanner对象
		Scanner myscanner  = new Scanner(System.in);
		//3.1接收用户输入
		System.out.println("请输入名字：");
		String name = myscanner.next();//接收用户输入名字
		System.out.println("请输入年龄：");
		int age = myscanner.nextInt();//接收用户输入年龄
		System.out.println("请输入薪水：");
		double salary = myscanner.nextDouble();//接收用户输入薪水

		// 1. next() - 读取单个单词（遇到空格停止）
		System.out.print("请输入名字: ");
		String name1 = myscanner.next();

		// 2. nextLine() - 读取整行（包括空格）
		System.out.print("请输入全名: ");
		String name2 = myscanner.nextLine();

		// 3. next().charAt(0) - 读取单个字符
		System.out.print("请输入首字母: ");
		char firstChar = myscanner.next().charAt(0);


		System.out.println("信息如下：");
		System.out.println("姓名:" + name + "\t年龄：" + age + "\t薪水:" + salary);

	}
}