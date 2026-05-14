// ººÂäËþ
public class HanoiTower1 {
	// main ·½·¨
	public static void main(String[] args){
		Tool myTool = new Tool();
		int num = 2;
		myTool.Move(num, 'A', 'B', 'C');
	}
}

class Tool {
	public void Move(int num, char a, char b, char c){
		if(num == 1){
			System.out.println(a + "->" + c);
		}else{
			Move(num-1, a, c, b);
			System.out.println(a + "->" + c);
			Move(num-1, b, a, c);
		}
	}
}