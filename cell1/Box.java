package com.company;

import javax.swing.*;
import java.awt.*;

public class Box extends JPanel {

    Field cell;
    public Box (int x, int y) {
        super();
        cell = new Field();
        setBounds(x * Main.SIZE, y * Main.SIZE, Main.SIZE, Main.SIZE);
        setBackground(Config.getColor(Rule.NONE));
    }


    public void setColor () {
        setBackground(Config.getColor(cell.status));
    }

    void step1 () {
        cell.step1();
        setColor();
    }

    void step2 () {
        cell.step2();
        setColor();
    }
}
