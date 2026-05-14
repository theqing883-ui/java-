// 可变参数练习
public class VarParameterExercise {
	public static void main(String[] args) {
		HspMethod myHspMethod = new HspMethod();
		String[] res = myHspMethod.showScore("liming",60,60.1);
		System.out.println("姓名\t" + "总成绩\t\n" + res[0] +
		 "\t" + res[1]);
	}
}
class HspMethod{
	public String[] showScore(String name, double... score){
		double sum = 0;
		for(int i = 0; i < score.length; i++){
			sum += score[i];
		}

		String[] res = new String[2];
		res[0] = name;
		res[1] = sum + "";
		return res;
		// 也可以改为返回字符串类型
		// return name + "有" + score.length + "门课的总成绩为" + sum;

	}
}