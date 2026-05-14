public class Arraytest {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, -3, 8, 0};
        System.out.println("原数组");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        Tool myTool = new Tool();
        myTool.bubbleSort(a);
        System.out.println("新数组");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

// 在IDEA中的run = 编译 + 运行；

/*
编写一个方法，可以完成对int数组冒泡排序的功能
学员练习 ， 使用快捷键的开发项目
*/
class Tool {
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class Person {
    int age;
    String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}