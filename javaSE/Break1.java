//random() 返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。[0,1)
//break 介绍
//标签的使用
// 跳转控制语句break
// 注意事项和细节说明：break语句出现在多层嵌套的语句块中时，可以通过标签指明要终止的是哪
// 
// 
// lable1:
//         for(int j = 0;j < 4;j++){
//             lable2:
//             for(int i = 0; i < 10; i++){
//                 if(i == 2){
//                     break lable1;
//                 }
//                 System.out.println("ji=" + j + i);  
//             }         
//         }   
// 
// 老韩解读
// （1）break语句可以指定退出哪层
// （2）label1是标签，名字由程序员指定。
// （3）break后指定到哪个label就退出到哪里
// （4）在实际的开发中，尽量不要使用标签。
// （5）如果没有指定break，默认退出最近的循环体


import java.util.Scanner;
public class Break1{
    //main方法
    public static void main(String[] args) {
        //测试random()
        // for(int i = 0;i < 10; i++){
        //     System.out.println((int)(Math.random() * 100) + 1);
        // }
        int count = 0; 
        while(true){
            int num1 = (int)(Math.random() * 100) + 1;
            count++;
            if(num1 == 100){
                System.out.println("第" + count + "次生成了100.");
                break;//当第一次生成100时，退出循环
            }
            else{
                System.out.println("生成了" + num1);
            }

        }

        //标签的使用
        lable1:
        for(int j = 0;j < 4;j++){
            lable2:
            for(int i = 0; i < 10; i++){
                if(i == 2){
                    //break lable1;
                    break;

                }
                System.out.println("ji=" + j + i);  
            }         
        } 

        //练习1
        int sum = 0;  
        for(int num  = 1; num <= 100; num++){
            sum += num;
            if(sum > 20){
                System.out.println(sum);
                break;
            }
        } 

        //练习2
        //"丁真".equals(name)[推荐，避免空指针]或者name.equals("丁真"),字符串比较，返回值为false或true
        int times = 3;
        Scanner myScanner = new Scanner(System.in); 
        for(int i = 1;i <= times; i++){
            System.out.println("请输入用户名：");
            String name = myScanner.next();
            System.out.println("请输入密码：");
            int keys = myScanner.nextInt();
            if("丁真".equals(name) && keys == 666){
                System.out.println("登录成功！");
                break;
            }else{
                System.out.println("用户名或密码错误，你还有" + (times - i) + "次机会。");
            }

        }
    }
}