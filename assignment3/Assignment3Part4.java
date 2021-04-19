package com.shpp.p2p.cs.ngrishchenko.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    TODO: Draw the pyramid
 */
public class Assignment3Part4 extends WindowProgram {

    private static final double BRICK_HEIGHT = 50;
    private static final double BRICK_WIDTH = 80;

    //number of bricks in bottom line
    private static final double BRICKS_IN_BASE = 7;

    public void run() {
        drawPyramid();
    }

    /**
     * draw pyramid with bricks
     * x - brick draw position
     * y - brick draw position
     * counter - count bricks in one line
     */
    private void drawPyramid() {
        double x;
        double y = getHeight();
        double counter = BRICKS_IN_BASE;

        for (int i = 0; i <= BRICKS_IN_BASE; i++) {
            y = y - BRICK_HEIGHT;
            x = (getWidth() - BRICKS_IN_BASE * BRICK_WIDTH) / 2 + i * (BRICK_WIDTH / 2);
            counter--;
            for (int j = 0; j <= counter; j++) {
                drawBrick(x, y);
                x = x + BRICK_WIDTH;
            }
        }
    }

    /**
     * draw one brick
     * @param x - brick draw position
     * @param y - brick draw position
     */
    private void drawBrick(double x, double y) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setColor(Color.BLACK);
        brick.setFillColor(Color.gray);
        brick.setFilled(true);
        add(brick);
    }
}
