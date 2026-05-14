// 练习
public class MethodExcercise {
	public static void main(String[] args){
		AA myTool = new AA();
		int num = 234;
		boolean flag = myTool.Judgment(num);
		if(flag){
			System.out.println(num + "是偶数");
		}else{
			System.out.println(num + "是奇数");
		}
		int row = 4;
		int column = 4;
		char element = '#';
		myTool.print(row,column,element);
	}
}

 // 编写类AA ，有一个方法：判断一个数是奇数odd还是偶数, 返回boolean
class AA {
	public boolean Judgment(int n){
		boolean flag;
		if(n % 2 == 0){
			flag = true;
		}else{
			flag = false;
		}
		return flag;
		// return n % 2 == 0;
	}

	public void print(int row, int column, char element){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				System.out.print(element + " ");
			}
			System.out.print("\n");
		}
	}
}
