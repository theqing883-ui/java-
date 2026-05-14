package com.hsp.draw.test;

import javax.swing.*;
import java.awt.*;

public class DrawCir extends JFrame {//DrawCir extends JFrame
                                    // 于一个窗口,当做一个画框
    private Panel mp = null;//创建一个面板对象
    public static void main(String[] args) {
        new DrawCir();
    }
    public DrawCir() {
        //初始化面板
        mp = new Panel();
        this.add(mp);//将面板放到框架
        this.setSize(900, 900);//设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //当创建窗口关闭，则程序完全退出
        this.setVisible(true);//可以显示
    }
}

//定义一个面板列 继承JPanel
 class Panel extends JPanel {//Panel extends JPane 理解为画纸
    @Override
    //把 Graphics g当做一个画笔
    public void paint(Graphics g) {//绘图的方法（动作）
        super.paint(g);
        //画圆
        g.drawOval(10, 10, 100, 100);
        //System.out.println("paint方法被调用");

        g.drawLine(200, 10, 100, 100);
        g.drawRect(200, 10, 90, 90);
        g.setColor(Color.blue);//选取画笔颜色
        g.drawRect(200, 10, 80, 80);

        g.setColor(Color.green);
        g.fillOval(20, 20, 50, 50);

        //画图片
        /*
        1、获取图片资源 /1.jpg在根目录中获取1.jpg
        * */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(Panel.class.getResource("/image/1.jpg"));
        g.drawImage(image, 20, 20, 657,626 , this);

        g.setColor(Color.red);
        g.setFont(new Font("宋体", Font.BOLD, 50));
        // 50, 50 为字体的左下角
        g.drawString("学习Java", 50, 50);


    }
    /*
        ● 绘图原理
        ✓ Component类提供了两个和绘图相关最重要的方法:
        1. paint(Graphics g)绘制组件的外观
        2. repaint()刷新组件的外观。

        ✓ 当组件第一次在屏幕显示的时候,程序会自动的调用paint()方法来绘制组件。

        ✓ 在以下情况paint()将会被调用:
        1. 窗口最小化,再最大化
        2. 窗口的大小发生变化
        3. repaint函数被调用

    * */
}