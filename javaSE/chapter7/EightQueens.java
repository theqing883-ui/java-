// 八皇后问题 Eight_queens???????????????????
public class EightQueens {
	public static void main(String[] args) {
		
	}
}
/*
1、int[] map = new int[8]; //map[i]的取值0-7，表示列，下标i:0-7表示行
2、不在同一行，意味着下标不相等map[i],map[j],i != j;
3、不在同一列，意味着取值不相等map[i] ！= map[j];
4、不在同一斜线，意味着map[i] == map[j] + 1 && i == j + 1，不成立;
*/

class Tool {
	public boolean Queens(int map[],int i){
		int k = 0;
		map[k] = i;
		for(row = 1, rew < 8, row++ ){
			for(col = 0, col < 8, col++){

			}
		}
		
	}
}