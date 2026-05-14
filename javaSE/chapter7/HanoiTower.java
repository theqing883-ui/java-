// 递归练习
/*
汉诺塔：汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。
大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照
大小顺序摞着64片圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序
重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆盘，在三根
柱子之间一次只能移动一个圆盘。
*/

public class HanoiTower {
	public static void main(String[] args){

	}
}

class Tool {
	public boolean Move(int num, char a, char b, char c){
		if(num == 1){
			System.out.println(a + "->" + c);
		}else{
			Move(num-1, a, c, b);
			System.out.println(a + "->" + c);
			Move(num-1, b, a, c);
		}
	} 
}