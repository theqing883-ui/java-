package com.hsp.draw.test;

import javax.swing.*;
import java.awt.*;

public class MyPanel1 extends JPanel {


    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillRect(10, 10, 100, 1000);

    }
}
