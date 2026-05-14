public class Chapter2Exercises {
	// main 方法
	public static void main(String[] args) {


		/*
		1.写一个数组存，{10,12,45,90}
		2.确定插入元素的索引，插入元素第一次被小于的元素的索引（insertElement <= array[i] index = i）
		   没有出现insertElement <= array[i]，则index = array.length
		3.扩容，array拷贝到arrayNew，但是要跳过index位置
		*/
	int[] array = {10, 12, 45, 90};
	int insertElement = 111;
	int index = -1;
	for(int i = 0;i < array.length; i++){
		if(insertElement <= array[i]){
			index = i;
			break;
		}else{
			index = array.length;
		}
	}







	int[] arrayNew = new int[array.length + 1];
	// if(insertElement <= array[0]){
	// 	arrayNew[0] = insertElement;
	// 	index = 0;
	// }else if(insertElement >= array[array.length-1]){
	// 	arrayNew[array.length] = insertElement;
	// 	index = array.length;
	// } else{
	// 	for(int i = 0; i < array.length; i++){
	// 		if((array[i] <= insertElement && insertElement <= array[i + 1])){
	// 			arrayNew[i + 1] = insertElement;
	// 			index = i + 1;
	// 		}
	// 	}
	// }



	//两个数组索引不一致，则可以在for里面写两个变量，i控制arrayNew,j控制array
	for(int i = 0, j = 0; i < arrayNew.length; i++){
		if(i == index){
			arrayNew[i] = insertElement;
		}else{
			arrayNew[i] = array[j];
			j++;
		}
	}
	// int j = 0;
	// for(int i = 0; i < arrayNew.length; i++){
	// 	if(i == index){
	// 		if(index == array.length){
	// 			break;
	// 		}
	// 		else{
	// 			i++;
	// 			j++;
	// 			arrayNew[i] = array[i-j];
	// 		}
			
	// 	}else{
	// 		arrayNew[i] = array[i - j];
	// 	}
	// }

	System.out.println("索引：" + index);
	array = arrayNew;
	for(int i = 0; i < array.length; i++){
		System.out.print(array[i] + " ");
	}


	}
}
