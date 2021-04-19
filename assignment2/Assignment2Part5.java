package com.shpp.p2p.cs.ngrishchenko.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: draw the illusion which contains black rect
        you can change the number of rect (number of columns and rows)
 */

public class Assignment2Part5 extends WindowProgram {

    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions.
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 350;

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run() {
        drawIllusion();
    }

    /**
     * use rect to draw illusion
     * x - start coordinate to draw illusion
     * y - start coordinate to draw illusion
     */
    private void drawIllusion() {
        double x = (getWidth() - ((BOX_SIZE + BOX_SPACING) * NUM_COLS) + BOX_SPACING) / 2;
        double y = (getHeight() - ((BOX_SIZE + BOX_SPACING) * NUM_ROWS) + BOX_SPACING) / 2;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                drawRect(x, y);
                x = x + BOX_SPACING + BOX_SIZE;
            }
            x = (getWidth() - ((BOX_SIZE + BOX_SPACING) * NUM_COLS) + BOX_SPACING) / 2;
            y = y + BOX_SPACING + BOX_SIZE;
        }
    }

    /**
     * draw one rect
     * @param x start coordinate to draw one rect
     * @param y start coordinate to draw one rect
     */
    private void drawRect(double x, double y) {
        GRect r = new GRect(x, y, BOX_SIZE, BOX_SIZE);
        r.setColor(Color.BLACK);
        r.setFilled(true);
        add(r);
    }
}
