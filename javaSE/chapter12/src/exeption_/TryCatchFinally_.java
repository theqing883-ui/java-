package exeption_;
/*
try-catch-finally 处理机制示意图
当程序中程序员try-catch和throws都没写，后有一个默认的throws

程序
try {
    代码/可能有异常
    }catch(Exception e) {
            //捕获到异常
            //1.当异常发生时
            //2.系统将异常封装成Exception 对象 e，传递给catch
            //3.得到异常对象后，程序员，自己处理
            //4.注意，如果没有发生异常
            catch代码块不执行
            }finally{
            //1.不管try代码块是否有异常发生，始终要执行finally
            //2.所以，通常将释放资源的代码，放在finally
             }
* */
public class TryCatchFinally_ {
    public static void main(String[] args) {

    }
}
