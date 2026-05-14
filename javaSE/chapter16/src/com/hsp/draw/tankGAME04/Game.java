package com.hsp.draw.tankGAME04;

import javax.swing.*;

public class Game extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        new Game();
    }
    public Game() {
        myPanel = new MyPanel();
        new Thread(myPanel).start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(myPanel.width + 25, myPanel.height + 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
