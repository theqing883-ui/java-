package com.hsp.generic_.customgeneric;

public class CustomMethodGeneric_ {
    public static void main(String[] args) {
        /*
        自定义泛型
            ● 自定义泛型方法
            ▷ 基本语法
            修饰符 <T,R...> 返回类型 方法名(参数列表) {
            }
            ▷ 注意细节
            1. 泛型方法，可以定义在普通类中，也可以定义在泛型类中
            2. 当泛型方法被调用时，类型会确定
            3. public void eat(E e) {}，修饰符后没有<T,R...> eat
            方法不是泛型方法，而是使用了泛型

        * */
        Bird<Integer, String, Float> bird = new Bird<>();
        bird.fly(12);//编译器自动判断实参的类型，再赋给泛型

    }
}

class Bird<T, R, M> {
    public <E> void fly(E e) {//泛型方法
        System.out.println(e);
    }

    public void cut(T t) {//不是泛型方法，只是方法使用了泛型
        System.out.println(t);
    }
}

class Fish {
    public <A> A show(A t) {//泛型方法
        System.out.println("t的值：" + t);
        System.out.println("t的类型：" +
                t.getClass().getSimpleName());
        return t;
    }
}
