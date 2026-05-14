package homework;

public class Homework01 {
    public static void main(String[] args) throws Exception {
        /*
        a) 编写应用程序EcmDef.java，接收命令行的两个参数(整数)，计算两数相除。
        b) 计算两个数相除，要求使用方法cal(int n1, int n2)
        c) 对数据格式不正确、缺少命令行参数、除0进行异常处理。
        * */

        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("不是两个参数！");
            }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int num3 = cal(num1, num2);
            System.out.println("计算结果是：" + num3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("输入的不是整数");
        }catch(ArithmeticException e) {
            System.out.println("分母不能为0");
        }

     /*   Scanner input = new Scanner(System.in);
        System.out.print("请输入第一个整数: ");
        String n1;
        int num1;
        while (true) {
            try {
                n1 = input.next();
                num1 = Integer.parseInt(n1);
                break;
            } catch (Exception e) {
                System.out.println("输入的不是整数，重新输入");
            }
        }
        System.out.print("请输入第二个整数:");
        int num2;
        while (true) {
            try {
                n1 = input.next();
                num2 = Integer.parseInt(n1);
                break;
            } catch (Exception e) {
                System.out.println("输入的不是整数，重新输入");
            }
        }
        int num3;
        try {
            num3 = cal(num1, num2);
            System.out.printf("结果是 ", num3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }

    public static int cal(int num1, int num2) {
        return num1 / num2;
    }
}
