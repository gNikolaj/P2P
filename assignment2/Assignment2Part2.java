package com.shpp.p2p.cs.ngrishchenko.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: Draw 4 circles at the corners
        and draw 1 rect at the centre
 */

public class Assignment2Part2 extends WindowProgram {
    /* The default width and height of the window */
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    /* the diameter of one circle
        the average between the width and height of the window
     */
    public static final int DIAMETER = (APPLICATION_HEIGHT + APPLICATION_WIDTH) / 2 / 3;

    public void run() {
        drawCircles();
        createAndDrawRect();
    }

    /**
     * draw rect that begins from the centre of the left top circle
     * this rect should be situated in the center
     */
    private void createAndDrawRect() {
        GRect r = new GRect(DIAMETER / 2, DIAMETER / 2, getWidth() - DIAMETER, getHeight() - DIAMETER);
        r.setColor(Color.WHITE);
        r.setFilled(true);
        add(r);
    }

    /**
     * draw 4 circles at rhe corners
     * diameter depends on the size of the window
     */
    private void drawCircles() {
        double x = 0;
        double y = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                createCircle(x, y);
                // use -2 and -1 to to fix incorrect window sizes
                x = getWidth() - DIAMETER - 2;
            }
            y = getHeight() - DIAMETER - 1;
            x = 0;
        }
    }

    /**
     * method create circle
     * @param x circle draws position
     * @param y circle draws position
     */
    private void createCircle(double x, double y) {
        GOval o = new GOval(x, y, DIAMETER, DIAMETER);
        o.setColor(Color.BLACK);
        o.setFilled(true);
        add(o);
    }
}
