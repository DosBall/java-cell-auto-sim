package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static int SIZE;
    public static int HEIGHT;
    public static int WIDTH;
    public static int SLEEPMS;
    public static double RND;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // String name = console.nextLine();
        // int age = console.nextInt();
        int size1 = console.nextInt();
        int height1 = console.nextInt();
        int width1 = console.nextInt();
        int sleemps1 = console.nextInt();
        double rnd1 = console.nextDouble();

        SIZE = size1;
        HEIGHT = height1;
        WIDTH = width1;
        SLEEPMS = sleemps1;
        RND = rnd1;








        CellScreen window = new CellScreen();
        javax.swing.SwingUtilities.invokeLater((Runnable) window);
    }

}
