package com.hspedu.interface_;

//编写一个方法，接入接口
/* 接口的多态
 * 1. USBInterface usbInterface 形参是接口类型 USBInterface
 * 2. 看到只要是实现了接口USBInterface的类，都可以作为这个方法的形参
 * 3. 实现接口的类的编译类型，可以是该接口类型【类似向上转型】
 * 4. 接口数组
 * 5. 多态传递
 * */

interface USBInterface_ {
    void work();
}

public class InterfacePolyArr {
    public static void main(String[] args) {
        USBInterface_[] usb = new USBInterface_[2];
        usb[0] = new Phone_();//向上转型
        usb[1] = new Camera_();

        for (USBInterface_ i : usb) {
            i.work();
            if (i instanceof Phone_) {//判读i的编译类型是不是Phone_
                ((Phone_) i).call();//向下转型
            }
        }
    }
}

class Phone_ implements USBInterface_ {
    public void work() {
        System.out.println("Phone 正在工作。。。");
    }

    public void call() {
        System.out.println("Phone 正在通话");
    }
}

class Camera_ implements USBInterface_ {
    public void work() {
        System.out.println("Camera 正在工作。。。");
    }
}
