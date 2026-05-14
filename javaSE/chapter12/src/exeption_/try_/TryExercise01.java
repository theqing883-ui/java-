package exeption_.try_;

public class TryExercise01 {
    public static int method() {
        int i = 1; //1
        try {
            i++; //i=2
            String[] names = new String[3];
            if (names[1].equals("tom")) { //空指针
                System.out.println(names[1]);
            } else
                names[3] = "hspedu";
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 1;
        } catch (NullPointerException e) {
            return ++i;//保存临时变量 temp = 3;
        } finally {
            i++; //i=4
            System.out.println("i=" + i); //i = 4
        }
    }

    public static void main(String[] args) {
        System.out.println(method()); // 3
    }
}
