package com.hspedu.interface_;


public class Computer {
    //编写一个方法，接入接口
    /* 接口的多态
    * 1. USBInterface usbInterface 形参是接口类型 USBInterface
    * 2. 看到只要是实现了接口USBInterface的类，都可以作为这个方法的形参
    * 3. 实现接口的类的编译类型，可以是该接口类型【类似向上转型】
    * */
    public void work(USBInterface usbInterface) {
        //通过接口，调用实现接口的类中的方法
        usbInterface.open();
        usbInterface.close();
    }
}
