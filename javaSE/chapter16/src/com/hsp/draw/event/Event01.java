package com.hsp.draw.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 讲解Java事件控制
 */
/*
● 基本说明
java 事件处理是采取 “委派事件模型”，当事件发生时，产生事件的对象，会把此 “信息” 传递
给 “事件的监听者” 处理，这里所说的 “信息” 实际上就是 java.awt.event 事件类库里某个
类所创建的对象，把它称为 “事件的对象”。
* */
/*
java事件处理机制
● 事件处理机制深入理解
1. 前面我们提到几个重要的概念 事件源，事件，事件监听器我们下面来全面的介绍它们。
2. 事件源：事件源是一个产生事件的对象，比如按钮，窗口等。
3. 事件：事件就是承载事件源状态改变时的对象，比如当键盘事件、鼠标事件、窗口事件
    等等，会生成一个事件对象，该对象保存着当前事件很多信息，比如KeyEvent 对象有
    含义被按下键的Code值。java.awt.event包和javax.swing.event包中定义了各种事
    件类型

4. 事件监听器接口:
    (1)当事件源产生一个事件，可以传递给事件监听者处理
    (2)事件监听者实际上就是一个类，该类实现了某个事件监听器接口
    比如前面我们案例中的MyPanel就是一个类，它实现了
    KeyListener接口，它就可以作为一个事件监听者，对接受到的事件
    进行处理
    (3)事件监听器接口有多种，不同的事件监听器接口可以监听不同的
    事件.一个类可以实现多个监听接口
    (4)这些接口在java.awt.event包和javax.swing.event包中定义。
    列出常用的事件监听器接口,查看jdk文档聚集。
 * */
public class Event01 extends JFrame {
    private MyPanel01 mp = null;

    public Event01() {
        this.mp = new MyPanel01();
        this.add(mp);
        this.addKeyListener(mp);
        //使JFrame可以监听mp的键盘事件
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Event01();
    }

}

//KeyListener 键盘监听器
class MyPanel01 extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillOval(x, y, 20, 20);
    }


    @Override//监听键盘字符输入
    public void keyTyped(KeyEvent e) {

    }

    @Override//当某按键按下会触发
    public void keyPressed(KeyEvent e) {
        // System.out.println(e.getKeyChar()+ "按下");
        //JAVA中会给键盘的每一个按键分配一个值 eg:KeyEvent.VK_DOWN
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN向下所对应的Code值
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();//repaint()方法调用会，触发paint方法进行重绘


    }

    @Override//当某按键松开会触发
    public void keyReleased(KeyEvent e) {

    }

}
