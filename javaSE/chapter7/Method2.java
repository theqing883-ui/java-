// 成员方法介绍

// 构造一个方法 遍历输出一个数组
public class Method2 {
	// main 方法
	public static void main(String[] args) {
		// 
		int[][] map = {{0,0,1},{1,1,1},{1,1,3}};
		myTool tool = new myTool();
		tool.Output(map);
	}
}

class myTool {
	public void Output(int[][] array) {
		for(int i = 0;i < array.length; i++){
			for(int j = 0;j < array[i].length; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}