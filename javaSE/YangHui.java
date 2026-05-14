public class YangHui {
	// main 方法
	public static void main(String[] args) {
		/*
		1
		1 1
		1 2 1
		1 3 3 1
		1 4 6 4 1
		1 5 10 10 5 1
		【提示】
		1.第一行有1个元素，第n行有n个元素
		2.每一行的第一个元素和最后一个元素都是1
		3.从第三行开始，对于非第一个元素和最后一个元素的元素的值,等于上一行某两数之和。
		*/
		int layers = 11;
		int[][] yangHui = new int[layers][];
		// if(layers == 1){
		// 	yangHui[0] = new int[1];
		// 	yangHui[1][0] = 1;
		// }else if(layers == 2){
		// 	yangHui[0] = new int[1];
		// 	yangHui[1][0] = 1;
		// 	yangHui[1] = new int[2];
		// 	yangHui[1][0] = 1;
		// 	yangHui[1][1] = 1;
		// }else{
		// 	yangHui[0] = new int[1];
		// 	yangHui[0][0] = 1;
		// 	yangHui[1] = new int[2];
		// 	yangHui[1][0] = 1;
		// 	yangHui[1][1] = 1;
			for(int i = 0; i < yangHui.length; i++){
				yangHui[i] = new int[i + 1];
				for(int j = 0; j < yangHui[i].length; j++){
					if(j == 0){
						yangHui[i][j] = 1;
					}else if(j == i){
						yangHui[i][j] = 1;
					}else{
						yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
					}
				}
			}
		// }
		// 输出
		for(int i = 0; i < yangHui.length; i++){
			for(int j = 0; j < yangHui[i].length; j++){
				System.out.print(yangHui[i][j] + "\t");					
			}
			System.out.println();
		}	
	}
}