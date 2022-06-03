package com.company;

import java.awt.*;

public class Config {


    public static Color getColor (Rule status) {

        return switch (status) {
            case NONE -> Color.BLACK;
            case BORN -> Color.GREEN;
            case LIVE -> Color.WHITE;
            case DIED -> Color.RED;
        };
    }
}
