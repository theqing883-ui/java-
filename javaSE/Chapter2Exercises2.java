public class Chapter2Exercises2 {
	// main 方法
	public static void main(String[] args) {
		/*
		*/
		int num = 10;
		int[] array = new int[num];
		for(int i = 0; i < num; i++){
			array[i] = (int)(Math.random() * 100) + 1;
		}
		int sum = 0;
		double avg;
		int max = array[0];
		int maxIndex = 0;
		int flag = -1;
		int[] arrayNew = new int[num];
		System.out.println("原数组为：");
		for(int i = 0; i < num; i++){
			System.out.print(array[i] + " ");
			arrayNew[i] = array[num - i - 1];
			sum += array[i];
			if(max < array[i]){
				max = array[i];
				maxIndex = i;
			}else if(array[i] == 8){
				flag = 1;
				break;
			}
		}
		System.out.println("\n逆序数组为：");
		for(int i = 0; i < num; i++){
			System.out.print(arrayNew[i] + " ");
		}
		System.out.print("最大值：" + max + "\n最大值索引:" + maxIndex);
		System.out.print("和：" + sum + "\n平均值:" + (double)sum / num);
		if(flag ==  1){
			System.out.println("\n数组中有8");
		}else{
			System.out.println("\n数组中没有8");		
		}


	}
}