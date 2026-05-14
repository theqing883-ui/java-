// 迷宫练习(思想)
public class MiGong {

	// main方法
	public static void main(String[] args){
		/*
			思路：
			1、先用数组创建迷宫：int[][] map =[][];
			2、规定1表示障碍物，0表示可通行
		*/
		int[][] map = new int[8][7];
		// 3、将外侧轮廓设置好
		// for(int i = 0; i < map.length; i++){
		// 	for(int j = 0; j < map[i].length; j++){
		// 		if(i == 0 || i == 7 || j == 0 || j == 6){
		// 			map[i][j] = 1;
		// 		}
		// 	}
		// }
		for(int i = 0; i < map[0].length; i++){
			map[0][i] = 1;
			map[map.length - 1][i] = 1;
		}for(int i = 0; i < map.length; i++){
			map[i][0] = 1;
			map[i][map[0].length - 1] = 1;
		}
		// 中间障碍物
		map[3][1] = 1;
		map[3][2] = 1;
		
		
		// 回溯现象
		map[3][2] = 1;
		map[2][2] = 1;
		map[4][2] = 1;
		map[5][2] = 1;
		map[6][2] = 1;
		map[6][1] = 1;
		

		System.out.println("=====找路情况=====");
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 7; j++){
				System.out.print(map[i][j] + " ");
			}
				System.out.print("\n");

		}

		Tool myTool = new Tool();
		boolean res = myTool.FindWay(map,1,1);
		if(res){
		System.out.println("找到路了");
		}else{
			System.out.println("没找到路");
		}


		System.out.println("=====当前地图情况=====");
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 7; j++){
				System.out.print(map[i][j] + " ");
			}
				System.out.print("\n");

		}
	}
}

class Tool {
	/*
		1、找到返回true,找不到返回false
		2、map[][]表示迷宫
		3、i,j表示小老鼠的位置
		4、0 表示可以走的路，1表示障碍物，2 表示可以走，3表示可以走，但是走不通
		5、map[6][5] == 2就说明找到通路了，否则继续找
		6、找路的策略，先下—>右->上->左
	*/
	public boolean FindWay(int[][] map, int i, int j){
		
		if(map[6][5] == 2){
			return true;
		}else{
			if(map[i][j] == 0){
				map[i][j] = 2; 
				if(FindWay(map, i + 1, j )){// 下
					return true;
				}else if(FindWay(map, i, j + 1)){// 右
					return true;
				}else if(FindWay(map, i-1, j)){// 上
					return true;
				}else if(FindWay(map, i, j - 1)){// 左
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}

			}else{
				return false;
			}
		}
	}
}