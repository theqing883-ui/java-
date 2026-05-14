package exeption_;

public class Exception02 {
    public static void main(String[] args) {
        String name = null;
        int[] age = {1,2,3};

//        System.out.println(name.length());//NullPointerException【空指针异常】
//        System.out.println(age[4]);//ArrayIndexOutOfBoundsException【数组越界异常】
        A obj = new B();//向上转型
        B obj2 = (B)obj;//向下转型
//        C obj3 = (C)obj;//这里会ClassCastException【类型转换异常】

        String str = "1232";
        int num = Integer.parseInt(str);
        String str2 = "xyz";
        int num2 = Integer.parseInt(str2);//NumberFormatException【数据格式不正确异常】


    }
}
class A{}
class B extends A{}
class C extends B{}
