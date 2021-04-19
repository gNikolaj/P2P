package com.shpp.p2p.cs.ngrishchenko.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: use one method two times
        ant draw two pawprints in different positions
 */

public class Assignment2Part3 extends WindowProgram {
    /* Constants controlling the relative positions of the
     * three toes to the upper-left corner of the pawprint.
     */
    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /* The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions.
     */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }
    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *
     * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */
    private void drawPawprint(double x, double y) {
        drawFirstToe(x, y);
        drawSecondToe(x, y);
        drawThirdToe(x, y);
        drawHeel(x, y);
    }

    /**
     * draws a hell of pawprint
     * @param x start coordinate to draw a heel
     * @param y start coordinate to draw a heel
     */
    private void drawHeel(double x, double y) {
        GOval h = new GOval(HEEL_OFFSET_X + x, HEEL_OFFSET_Y + y, HEEL_WIDTH, HEEL_HEIGHT);
        h.setColor(Color.BLACK);
        h.setFilled(true);
        add(h);
    }

    /**
     * draws a toe of pawprint(third)
     * @param x start coordinate to draw a toe
     * @param y start coordinate to draw a toe
     */
    private void drawThirdToe(double x, double y) {
        GOval tt = new GOval(THIRD_TOE_OFFSET_X + x, THIRD_TOE_OFFSET_Y + y, TOE_WIDTH, TOE_HEIGHT);
        tt.setColor(Color.BLACK);
        tt.setFilled(true);
        add(tt);
    }

    /**
     * draws a toe of pawprint(second)
     * @param x start coordinate to draw a toe
     * @param y start coordinate to draw a toe
     */
    private void drawSecondToe(double x, double y) {
        GOval st = new GOval(SECOND_TOE_OFFSET_X + x, SECOND_TOE_OFFSET_Y + y, TOE_WIDTH, TOE_HEIGHT);
        st.setColor(Color.BLACK);
        st.setFilled(true);
        add(st);
    }

    /**
     * draws a toe of pawprint(first)
     * @param x start coordinate to draw a toe
     * @param y start coordinate to draw a toe
     */
    private void drawFirstToe(double x, double y) {
        GOval ft = new GOval(FIRST_TOE_OFFSET_X + x, FIRST_TOE_OFFSET_Y + y, TOE_WIDTH, TOE_HEIGHT);
        ft.setColor(Color.BLACK);
        ft.setFilled(true);
        add(ft);
    }

}
