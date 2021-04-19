package com.shpp.p2p.cs.ngrishchenko.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: draw the flag
     and write the information about flag at the right bottom corner
 */

public class Assignment2Part4 extends WindowProgram {

    /* colors that I use to draw the flag */
    private static final Color MY_BLUE = new Color(15, 41, 102);
    private static final Color MY_ORANGE = new Color(252, 208, 48);
    private static final Color MY_RED = new Color(222, 38, 38);

    /* The default width and height of the flag */
    private static final int FLAG_WIDTH = 300;
    private static final int FLAG_HEIGHT = 220;

    /* The default width of one stripe*/
    private static final double STRIPE_WIDTH = FLAG_WIDTH / 3.0;

    /*The default width and height of the window*/
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 300;

    public void run() {
        drawFlag();
        addLabel();
    }

    /**
     * add text with the name of the country that appears on the flag
     */
    private void addLabel() {
        GLabel l = new GLabel("Flag of Chad");
        l.setFont("London-17");
        l.setColor(Color.BLACK);
        //use - 1px to improve the visibility of the text
        add(l, getWidth() - l.getWidth() - 1,getHeight() - 1);
    }

    /**
     * draw the flag
     * x - start coordinate to draw a flag
     * y - start coordinate to draw a flag
     * color - color to each stripe
     */
    private void drawFlag() {
        double x = (getWidth() - FLAG_WIDTH) / 2.0;
        double y = (getHeight() - FLAG_HEIGHT) / 2.0;
        Color color = Color.BLACK;

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    color = MY_BLUE;
                    break;
                case 1:
                    color = MY_ORANGE;
                    break;
                case 2:
                    color = MY_RED;
                    break;
            }
            drawStripe(x, y, color);
            x = x + STRIPE_WIDTH;
        }
    }

    /**
     * draw one stripe
     * @param x start coordinate to draw a stripe
     * @param y start coordinate to draw a stripe
     * @param color color that each stripe will have
     */
    private void drawStripe(double x, double y, Color color) {
        GRect r = new GRect(x, y, STRIPE_WIDTH, FLAG_HEIGHT);
        r.setColor(color);
        r.setFilled(true);
        add(r);
    }
}
