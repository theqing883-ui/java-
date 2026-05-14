package com.hsp.draw.tankGAME;

import javax.swing.*;

public class Game extends JFrame {
    MyPanel myPanel  = null;
    public static void main(String[] args) {
        new Game();
    }
    public Game() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
