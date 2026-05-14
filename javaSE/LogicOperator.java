//逻辑运算符
public class LogicOperator{
	public static void main(String[] args) {
		
		int age = 50;
		// &&
		if(age > 20 && age < 90){
			System.out.println("okkkkkk!");
		}

		//&
		if(age > 20 & age < 90){
			System.out.println("oooooook!");
		}

		int a = 4;
		int b = 9;

		//短路与（&&	）如果第一个条件为false，则第二个调节不会再执行，最终为false（效率高）
		if(a > 5 && ++b < 90){
			System.out.println("ok100!");
		}
		System.out.println("a=" + a + "\tb=" + b );//4,9

		//逻辑与（&）如果第一个条件为false，则第二个条件也会再执行，最终为false
		if(a > 5 & ++b < 90){
			System.out.println("ok200!");
		}
		System.out.println("a=" + a + "\tb=" + b );//4,10
		System.out.println("\n=====================");//4,10

		age = 50;
		// ||

		if(age < 20 || age < 90){
			System.out.println("okkkkkk!");
		}

		// |
		if(age < 20 | age < 90){
			System.out.println("oooooook!");
		}

		a = 4;
		b = 9;
		//短路或（||	）如果第一个条件为true，则第二个条件不会再执行，最终为true（效率高）
		if(a < 5 || ++b < 90){
			System.out.println("ok300!");
		}
		System.out.println("a=" + a + "\tb=" + b );//4,9

		//逻辑或（|）如果第一个条件为true，则第二个调节也会再执行，最终为true
		if(a < 5 | ++b < 90){
			System.out.println("ok400!");
		}
		System.out.println("a=" + a + "\tb=" + b );//4,10

		boolean x = true;
		boolean y = false;
		short z = 46;

		if((z++ == 46) && (y = true)) {
			 z++;
		}
		
		
		if(( x = false) || (++z == 49)){
			z++;
		}
		
		System.out.println("z=" + z);





	}
}
