package com.hspedu.single_;
/*
1.什么是设计模式
1).静态方法和属性的经典使用
2).设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
    设计模式就像是经典的棋谱，不同的棋局，我们用不同的棋谱，免去我们自己再思考和摸索
*  */

/*
1.什么是单例模式单例 (单个的实例)
    所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，
    对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法
2.单例模式有两种方式: 1) 饿汉式 2) 懒汉式
* */

/*单例模式
    （饿汉式：一旦类加载就把唯一对象创建了）
    [即使未使用是这个对象，一旦类加载这个对象就会被创建，
    所以饿汉式可能造成资源浪费]
1.将构造器私有化
2.在类的内部创建一个对象
  (为了静态方法可以访问到这个对象，所以要把这个对象设为静态的)
3.提供一个公共的static 方法，返回gf对象。
* */
public class SingleTon01 {
    public static void main(String[] args) {
        System.out.println(GirlFriend.n1);
        System.out.println("---------现在还没有使用对象----------\n");
        System.out.println("---------第一次使用对象----------");
//        GirlFriend gf = GirlFriend.getInstance();
        System.out.println(GirlFriend.getInstance());
        System.out.println("---------第二次使用对象----------");
//        GirlFriend gf2 = GirlFriend.getInstance();
        System.out.println(GirlFriend.getInstance());
    }
}

//有一个类 GirlFriend，希望在重新运行过程中只能创建一个对象
class GirlFriend {
    //(为了静态方法可以访问到这个对象，所以要把这个对象设为静态的)
    private static GirlFriend gf = new GirlFriend("cc");
    public static int n1 = 10;
    private String name;

    //保证只能创建一个GirlFriend对象
    //1.将构造器私有化
    //2.在类的内部创建一个对象
    // (为了静态方法可以访问到这个对象，所以要把这个对象设为静态的)
    //3.提供一个公共的static 方法，返回gf对象。
    private GirlFriend(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    //外面不能创建对象，所以需要这个方法为静态的
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}