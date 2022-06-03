package com.company;

import java.util.ArrayList;

public class Field {
    ArrayList<Field> near;
    Rule status;

    public Field() {
        status = Rule.NONE;
        near = new ArrayList<>();
    }

    void addNear (Field cell) {
        near.add(cell);
    }

    void step1() {
        int around = countNearCells();
        status = status.step1(around);
    }

    void step2() {
        status = status.step2();
    }

    int countNearCells() {
        int count = 0;
        for (Field cell : near)
            if (cell.status.isCell())
                count++;
        return count;
    }
}
