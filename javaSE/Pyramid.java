//多重循环
public class Pyramid{
	public static void main(String[] args) {
		int totalLevel = 20;
		//初步
		int i = 1;
		while(i <= totalLevel){
			int j = 0;
			while(j < i){
				System.out.print("*");
				j++;
			}
			i++;
			System.out.print("\n");

		}

		//改进1
		i = 1;
		while(i <= totalLevel){
			int j = 0;
			while(j < totalLevel - i){//空格数为总层数-现在的层数（上小）
				System.out.print(" ");
				j++;
			}
			j = 0;
			while(j < 2*i-1){
				System.out.print("*");//*数为2*现层数-1
				j++;
			}
			i++;
			System.out.print("\n");

		}


		//改进2
		i = 1;
		while(i <= totalLevel){
			int j = 0;
			while(j < totalLevel - i){//空格数为总层数-现在的层数（上小）
				System.out.print(" ");
				j++;
			}
			j = 0;
			while(j < 2*i-1){//内部的空格数加上*数，一共为2*现层数-1
				System.out.print("*");
				j++;
				while(j < 2*i-2 && i != totalLevel){
					System.out.print(" ");
					j++;
				}
				while(j < 2*i - 1){
					System.out.print("*");
					j++;
				}
			}
			i++;
			System.out.print("\n");
		}
	} 
}