package com.company;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;


public class CellScreen implements Runnable {

    JFrame screen;
    Box[][] cells;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    void initFrame() {
        screen = new JFrame();
        screen.getContentPane().setLayout(null);
        screen.setSize(Main.SIZE * Main.WIDTH + 16, Main.SIZE * Main.HEIGHT + 39);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
        screen.setTitle("CellScreen");
    }

    void initBoxes() {
        cells = new Box[Main.WIDTH][Main.HEIGHT];
        for (int x = 0; x < Main.WIDTH; x++)
            for (int y = 0; y < Main.HEIGHT; y++) {
                cells [x][y] = new Box(x, y);
                screen.add(cells[x][y]);
            }
        for (int x = 0; x < Main.WIDTH; x++)
            for (int y = 0; y < Main.HEIGHT; y++)
                for (int sx = -1; sx <= 1; sx++)
                    for (int sy = -1; sy <= 1; sy++)
                        if (!(sx == 0 && sy == 0))
                            cells[x][y].cell.addNear(cells[(x + sx + Main.WIDTH) % Main.WIDTH][(y + sy + Main.HEIGHT) % Main.HEIGHT].cell);

        for (int x = 0; x < Main.WIDTH; x++)
            for (int y = 0; y < Main.HEIGHT; y++) {
            if (ThreadLocalRandom.current().nextDouble() < Main.RND) {
                cells[x][y].cell.status = Rule.LIVE;
                cells[x][y].setColor();
            }
        }
    }

    private void initTimer() {
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Main.SLEEPMS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Main.WIDTH; x++)
                for (int y = 0; y < Main.HEIGHT; y++) {
                    if (flop)
                        cells[x][y].step1();
                    else
                        cells[x][y].step2();
                }
        }
    }
}
