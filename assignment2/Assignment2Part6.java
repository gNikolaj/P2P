package com.shpp.p2p.cs.ngrishchenko.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: draw a caterpillar
        user can change size of it(change number of circles)
 */

public class Assignment2Part6 extends WindowProgram {

    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions.
     */
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 250;

    /* diameter of one circle(one part of caterpillar)*/
    public static final int CIRCLE_DIAMETER = 100;

    /* number of circles that caterpillar contains*/
    public static final int CATERPILLAR_SIZE = 6;

    public void run() {
        drawCaterpillar();
    }

    /**
     * draw all caterpillar
     * circleX - start coordinate to draw a part of caterpillar(circle)
     * circleY - start coordinate to draw a part of caterpillar(circle)
     */
    private void drawCaterpillar() {
        double circleX = 0;
        double circleY;
        for (int i = 0; i < CATERPILLAR_SIZE; i++) {
            if (i % 2 == 0) {
                circleY = CIRCLE_DIAMETER / 2.0 - CIRCLE_DIAMETER / 10.0;
            }
            else {
                circleY = 0;
            }
            drawCircle(circleX, circleY);
            circleX = circleX + (CIRCLE_DIAMETER / 2.0 + CIRCLE_DIAMETER / 10.0);
        }
    }

    /**
     * draw one circle
     * @param x start coordinate to draw a circle
     * @param y start coordinate to draw a circle
     */
    private void drawCircle(double x, double y) {
        GOval o = new GOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        o.setFillColor(Color.GREEN);
        o.setColor(Color.RED);
        o.setFilled(true);
        add(o);
    }
}
