//continue 介绍:结束本次循环，跳过本次循环的循环体。也可以与标签结合使用

public class Continue{
	public static void main(String[] args) {
		label1:
		for(int j = 0; j < 4; j++){
			label2:
			for(int i = 0; i < 10; i++){
				if(i == 2){
					//看看分别输出什么值，并分析
					//continue；
					// continue label2;
					continue label1;
		 		}
				System.out.println("i="+i);
			}
		}
	}
}

