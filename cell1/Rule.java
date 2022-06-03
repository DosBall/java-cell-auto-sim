package com.company;
import java.util.ArrayList;

public enum Rule {
    NONE,
    BORN,
    LIVE,
    DIED;

    ArrayList<Integer> people = new ArrayList<Integer>();
    public Rule step1 (int around) {
        return switch (this) {
            case NONE -> (around == 3) ? BORN : NONE;
            case LIVE -> (around <= 1 || around >= 4) ? DIED : LIVE;
            default -> this;
        };
    }

    public Rule step2 () {
        return switch (this) {
            case BORN -> LIVE;
            case DIED -> NONE;
            default -> this;
        };
    }

    public boolean isCell () {
        return this == LIVE || this == DIED;
    }
}
