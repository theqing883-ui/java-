package com.hsp.draw.tankGAME05;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;


public class Game extends JFrame {
    MyPanel myPanel = null;

    public Game() {
        System.out.println("游戏:1新游戏，2继续游戏");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        myPanel = new MyPanel(key);
        new Thread(myPanel).start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(myPanel.width + 270, myPanel.height + 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        WindowMonitor();

    }

    public static void main(String[] args) {
        new Game();
    }

    public void WindowMonitor() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口正在关闭");
                Recorder.writeRecord();
//                                  Recorder.recordCoordinate();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }


            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
