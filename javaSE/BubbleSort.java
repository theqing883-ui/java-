//冒泡排序
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {24, 69, 80, 57, 13,2,34,5,5,6,1};

		for(int j = array.length; j > 1; j--){
			for(int i = j, k = 0; i > 1 ; i--, k++){
				if(array[k] > array[k + 1]){
					int temp;
					temp = array[k];
					array[k] = array[k + 1];
					array[k + 1] = temp;
				}
			}
		}
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		
		//推荐
		System.out.print("\n改进后：\n");
		for(int i = 0; i < array.length - 1; i++){//需要进行length-1轮比较
			for(int j = 0; j < array.length - 1 - i; j++){//第i轮需要进行length-1-i次比较
				if(array[j] > array[j + 1]){//>:由小到大(第一轮确定最大值在最后)，>:由大到小(第一轮确定最小值在最后)
					int temp;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			} 
		}
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}