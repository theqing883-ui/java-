public class OverLoadExercise{
	public static void main(String[] args) {
		
		Methods myMethods = new Methods();
		myMethods.m(12);
		myMethods.m(12,10);
		myMethods.m("我在学java");
		int res = myMethods.max(12, 49);
		double res1 = myMethods.max(12.2, 4.6);
		double res2 = myMethods.max(12.2, 111.6, 90.3);
		System.out.println("res , res1, res2\n"  + res + " " + res1 
			+ " " + res2);

	}
}

class Methods {
	public void m(int n){
		System.out.println("平方=" + (n * n));
	} 
	public void m(int n, int n1){
		System.out.println("乘积=" + (n * n1));
	}
	public void m(String s1){
		System.out.println("输入的字符串为："  + s1);
	} 

	public int max(int n1, int n2){
		return ((n1 > n2 ? n1 : n2));
	} 
	public double max(double n1, double n2){
		return  ((n1 > n2 ? n1 : n2));
	} 
	public double max(double n1, double n2, double n3){
		return ((n3 > (n1 > n2 ? n1 : n2) ? n3 : (n1 > n2 ? n1 : n2)));
	} 
}