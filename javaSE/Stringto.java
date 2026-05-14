//字符串类型与基本数据类型的转换
public class Stringto{

	public static void main(String[] args) {
		//基本数据类型转换为字符串类型，直接加(+"")
		int n1  = 10;
		String s1 = n1 + "";
		System.out.println(s1);

		//字符串类型转换为基本数据类型
		String s2 = "10";
		int num1 = Integer.parseInt(s2);
		double num2 = Double.parseDouble(s2);
		float num3 = Float.parseFloat(s2);
		long num4 = Long.parseLong(s2);
		byte num5 = Byte.parseByte(s2);
		short num6 = Short.parseShort(s2);
		boolean b = Boolean.parseBoolean("true");
		//char num5 = Char.parseChar(s2);//不行

		//输出
		System.out.println("=============");
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		System.out.println(num6);
		System.out.println(b);
		//String不能直接转为char，只能取出其中一个字符给char
		System.out.println(s2.charAt(0));//取s2第一个字符
	}
}