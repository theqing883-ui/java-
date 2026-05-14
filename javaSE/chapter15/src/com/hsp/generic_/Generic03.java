package com.hsp.generic_;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
泛型语法和使用
● 泛型使用的注意事项和细节 GenericDetail.java
1. interface List<T>{}，public class HashSet<E>{}...等等
说明：T,E只能是引用类型
看看下面语句是否正确：

2. 在指定泛型具体类型后，可以传入该类型或者其子类类型

3. 泛型使用形式
List<Integer> list1 = new ArrayList<Integer>();
List<Integer> list2 = new ArrayList<>();//说明：
3. 如果我们这样写 List list3 = new ArrayList(); 默认给它的 泛型是[<E>就是 Object ]
即：
* */
public class Generic03 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();//OK
        //List<int> list2 = new ArrayList<int>();//错误

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<>();//说明：编译器会类型识别

        List list3 = new ArrayList();
        //等价于List<Objects> list3 = new ArrayList<>();
    }
}
