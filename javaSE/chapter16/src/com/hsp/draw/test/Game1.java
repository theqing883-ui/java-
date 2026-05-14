package com.hsp.draw.test;

import javax.swing.*;

public class Game1 extends JFrame {
    private MyPanel1 panel = null;

    public Game1() {
        panel = new MyPanel1();
        add(panel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Game1 game = new Game1();
    }
}
