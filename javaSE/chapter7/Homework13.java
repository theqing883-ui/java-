// 11

public class Homework13 {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		PassObject po = new PassObject();
		po.printAreas(c1,5);
	}
}

class Circle {
	double radius;
	
	public double findArea(double radius){
		return Math.PI * radius * radius;
	}
}

class PassObject {
	public void printAreas(Circle c, double times){
		System.out.println("radius\t" + "Area");
		for(double i = 1; i <= times; i++){
			System.out.println(i + "\t" +  c.findArea(i));
		}
	}
}