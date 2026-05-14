package exeption_.try_;

public class TryCatchDetail01 {
    public static void main(String[] args) {
        try {
            /*快捷键 ：ctrl alt T
            * 1.如果发生异常，异常后面的代码不再执行，直接到catch
            * 2.如果异常没有发生，则顺序执行try代码块，不会进入catch
            * 3.如果希望不管异常是否执行，都会执行的代码块（比如释放资源）
            *   则使用finally
            *  4.如果try代码块可能有多个异常，可以使用catch,分别捕获不同的异常
            *  5.要求子类的异常写在前面，父类的异常写在后面
            *  6.可以使用try-finally结构，不用catch，这种用法相当于没有捕获异常
            *  因此程序会直接崩。应用于，就是需要执行某段代码，不管是否发生异常，都
            *  必须执行某个业务逻辑。
            * */
            String str  = "12";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);
        }catch (Exception e){
            System.out.println("异常信息：" + e.getMessage());
        }finally {
            System.out.println("不管是否发生异常，finally都会执行！");
        }

    }
}
