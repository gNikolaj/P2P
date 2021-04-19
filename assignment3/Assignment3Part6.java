package com.shpp.p2p.cs.ngrishchenko.assignment3;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: Draws circles when you start program
        You can change CIRCLE_SIZE and NUM_ROWS NUM_COLS
        To see good animation - DON'T change that constants
 */

public class Assignment3Part6 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 6;
    private static final int NUM_COLS = 6;

    private static final int CIRCLE_SIZE = 50;

    /* The horizontal and vertical spacing between the circles. */
    private static final int CIRCLE_SPACING = 10;

    /* 5 seconds to animation*/
    public static final int TIME = 5000;

    private static final int SIZE_AND_SPACING = CIRCLE_SIZE + CIRCLE_SPACING;

    public void run() {
        addLabel();
        drawCircles();
    }

    /**
     * draw circles
     * timer - check time to end animation
     * time - pause to draw one circle
     * x - circle draw position
     * y- circle draw position
     */
    private void drawCircles() {
        double timer = 0;
        double time = TIME / (NUM_COLS * NUM_ROWS);
        double x = (getWidth() - NUM_COLS * SIZE_AND_SPACING) / 2;
        double y = (getHeight() - NUM_ROWS * SIZE_AND_SPACING) / 2;

        while (timer < TIME) {
            for (int i = 0; i < NUM_ROWS; i++) {
                if (timer > TIME) {
                    break;
                }
                for (int j = 0; j < NUM_COLS; j++) {
                    timer += time;
                    pause(time);
                    if (timer > TIME) {
                        break;
                    }
                    Color color = RandomGenerator.getInstance().nextColor();
                    drawCircle(x, y, color);
                    x = x + SIZE_AND_SPACING;
                    timeTracker.setLabel("Time: " + (timer / 1000));
                }
                x = (getWidth() - NUM_COLS * SIZE_AND_SPACING) / 2;
                y = y + SIZE_AND_SPACING;
            }
        }
    }

    GLabel timeTracker = null;

    /**
     * add label in left top corner
     */
    private void addLabel() {
        timeTracker = new GLabel("Time: ", 30,30);
        add(timeTracker);
    }

    /**
     * draw one circle
     * @param x - circle draw position
     * @param y - circle draw position
     * @param color - color to fill circle
     */
    private void drawCircle(double x, double y, Color color) {
        GOval c = new GOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
        c.setColor(color);
        c.setFilled(true);
        add(c);
    }
}