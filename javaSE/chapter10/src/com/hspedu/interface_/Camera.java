package com.hspedu.interface_;

//实现接口USBInterface
// 即：实现USBInterface规定的方法
public class Camera implements USBInterface {
    @Override
    public void open() {
        System.out.println("Camera open");
    }

    @Override
    public void close() {
        System.out.println("Camera open");
    }
}
