//return 退出所在的方法，如果写在main方法内，则表示退出程序。
public class Return1{
	//main方法
	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++){
			if(i == 3){
				System.out.println("哇哈哈哈哈哈哈哈！");
				// return;//退出程序
				// continue;//退出本次循环
				break;//退出循环
			}
			System.out.println("~~~~~~~");
		}
		System.out.println("go on...");
	}
}