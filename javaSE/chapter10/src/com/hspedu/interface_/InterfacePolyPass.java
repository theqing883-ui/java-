package com.hspedu.interface_;

//编写一个方法，接入接口
/* 接口的多态
 * 1. USBInterface usbInterface 形参是接口类型 USBInterface
 * 2. 看到只要是实现了接口USBInterface的类，都可以作为这个方法的形参
 * 3. 实现接口的类的编译类型，可以是该接口类型【类似向上转型】
 * 4. 接口数组
 * 5. 多态传递：IG继承IH，Teacher实现了IG，那么就相当于Teacher 也实现了IH
 * */



public class InterfacePolyPass {
    public static void main(String[] args) {
        IG ig = new Teacher();
        IH ih = new Teacher();
    }
}
interface IH{}
interface IG extends IH{}
class Teacher implements IG{}