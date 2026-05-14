//顺序查找
import java.util.Scanner;
public class Seqsearch {
	// main 方法
	public static void main(String[] args) {
		String[] array = {"白眉鹰王", "金毛狮王", "紫衫龙王", "青翼蝠王"};
		Scanner myScanner = new Scanner(System.in);
		System.out.println("输入字符:");
		String inputFlag = myScanner.next();
		int index = -1;
		for(int i = 0; i < array.length; i++){
			if(inputFlag.equals(array[i])){
				index = i;
				break;
			}
		}
		if(index != -1){
			System.out.println("已找到，索引为：" + index);
		}else{
			System.out.println("未找到");
			}
	}
}