//赋值运算符
public class AssignOperator{
	public static void main(String[] args) {
		
		int n1 = 10;
		n1 += 4;//等价于n1 = （int）（n1 + 4）;
		System.out.println("n1=" + n1);
		n1 /= 3;//n1 = n1 / 3;
		System.out.println("n1=" + n1);

		//复合赋值运算符，底层会自动进行强制类型转换
		byte b = 3;
		b += 2;//  b = (byte)(b + 2)运算后b为byte类型
		b++; //b = (byte)(b + 1)


	}
}