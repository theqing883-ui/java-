package com.hspedu.interface_;


//实现接口USBInterface
// 即：实现USBInterface规定的方法
public class Phone implements USBInterface{
    @Override
    public void open() {
        System.out.println("Phone open");
    }

    @Override
    public void close() {
        System.out.println("Phone close");
    }
}
