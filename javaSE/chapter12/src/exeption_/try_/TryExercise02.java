package exeption_.try_;

import java.util.Scanner;

public class TryExercise02 {
    public static void main(String[] args) {
        /*
        * 1.先创建Scanner
        * 2.使用无限循环
        * 3.当接收到的数据和需要类型不匹配时，抛出异常进入catch
        * 4.如果匹配则break;
        * */
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num;
        do {
            try {
                num = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("输入的不是整数，请重新输入：");
                sc.next();//关键：清空缓冲区的错误输入
            }
        } while (true);

    }
}

