// 练习
public class homework {
	public static void main(String[] args) {
		// 1
		double[] nums = {1.4, 2.3, 3.2, 10.3};
		A01 myA01 = new A01();
		double maxNum = myA01.max(nums);
		System.out.println("nums最大值为" + maxNum);
		// 2
		String[] strArray = {"123", "哇哈哈哈", "12345"};
		A02 myA02 = new A02();
		int flag = myA02.find(strArray, "12345");
		if(flag != -1){
			System.out.println("找到了，索引为" + flag);
		}else{
			System.out.println("没找到");
		}
		// 3
		Book myBook = new Book(52.0);
		System.out.println("目前的书价格：" + myBook.bookPrice);
		myBook.updatePrice();
		System.out.println("目前的书价格：" + myBook.bookPrice);
		// 4
		A03 myA03 = new A03();
		double[] arr = {1,3,4.444,5,4};
		String[] newArr = myA03.copyArr(arr);
		System.out.println("旧数组为：");
		for(int i = 0; i < newArr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("新数组为：");
		for(int i = 0; i < newArr.length; i++){
			System.out.print(newArr[i] + " ");
		}
		System.out.println();

		// 5
		Circle c1 = new Circle(4);
		c1.perimeter();
		c1.area();


		// 6
		Cale t1 = new Cale(12,0);
		t1.sum();
		t1.differece();
		t1.product();
		t1.quotient();

		// 7
		Dog dog1 = new Dog("陈叉叉", "白色", 5);
		dog1.show();
	}
}

class A01 {
	public double max(double[] nums){
		double maxNum = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(maxNum < nums[i]){
				maxNum = nums[i];
			}
		}
		return maxNum;
	}
}

class A02 { // 注意
	public int find(String[] strArray, String str){
		int index = -1;
		for(int i = 0; i < strArray.length; i++){
			if(str.equals(strArray[i])){
				index =  i;
			}
		}
		return index;
	}
}

class Book {
	double bookPrice;

	public Book(double bookPrice){
		this.bookPrice = bookPrice;
	}
	public void updatePrice(){
		if(this.bookPrice > 150){
			this.bookPrice = 150;
		}else if(this.bookPrice > 100){
			this.bookPrice = 100;
		}
	}
}

class A03{
	public String[] copyArr(double[] arr){
		String[] newArr = new String[arr.length];
		for(int i = 0; i < arr.length; i++){
			newArr[i] = arr[i] + "";
		}
		return newArr;
	}
}


class Circle {
	double r;
	public Circle(double r){
		this.r = r;
	}
	public void perimeter(){
		double perimeter = 2 * Math.PI * this.r;
		System.out.println("这个圆的周长为：" + perimeter);
	}
	public void area(){
		double area = Math.PI * this.r * this.r;
		System.out.println("这个圆的面积为：" + area);

	}
}

class Cale {
	double num1;
	double num2;
	public Cale(double num1, double num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	public void sum(){
		double sum = this.num1 + this.num2;
		System.out.println(this.num1 + "与" + this.num2 + 
			"的和为" + sum);
	}
	public void differece(){
		double differece = this.num1 - this.num2;
		System.out.println(this.num1 + "与" + this.num2 + 
			"的差为" + differece);
	}
	public void product(){
		double product = this.num1 * this.num2;
		System.out.println(this.num1 + "与" + this.num2 + 
			"的积为" + product);
	}
	public void quotient(){
		if(this.num2 != 0){
			double quotient = this.num1 / this.num2;
			System.out.println(this.num1 + "与" + this.num2 + 
				"的积为" + quotient);
		}else{
			System.out.println("除数不能为0");

		}
	}
}

class Dog {
	String name;
	String color;
	int age;
	public Dog(String name, String color, int age){
		this.name = name;
		this.color = color;
		this.age = age;
	}
	public void show(){
		System.out.println("这只dog的信息如下：");
		System.out.println("名字：" + this.name + 
			"\n颜色：" + this.color + "\n年龄：" + this.age);
	}

}