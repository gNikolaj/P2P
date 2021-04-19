package com.shpp.p2p.cs.ngrishchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

/*
    TODO: Karel draws a chess board with the help of beepers
 */
public class Assignment1Part4 extends KarelTheRobot {

    public void run() throws Exception {
        oneColumnSizeCheck();
        while (frontIsClear()) {
            putBeepersInLine();
            changeLineAndTurnLeft();
            putBeepersInLine();
            changeLineAndTurnRight();
        }
    }

    /**
     * Karel check the space ahead
     * If no space ahead, Karel turn left and move along left wall
     * @throws Exception
     */
    private void oneColumnSizeCheck() throws Exception {
        if (frontIsBlocked()) {
            turnLeft();
            if (frontIsBlocked()) {
                putBeeper();
            }
            putBeepersInLine();
        }
    }

    /**
     * Karel moves to the next row when all beepers putted
     * And turn right continue to put beepers
     * @throws Exception
     */
    private void changeLineAndTurnRight() throws Exception {
        turnRight();
        if (frontIsClear()) {
            if (beepersPresent()) {
                move();
                turnRight();
                move();
            }
            move();
            turnRight();
        }

    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Karel moves to the next row when all beepers putted
     * And turn left continue to put beepers
     * @throws Exception
     */
    private void changeLineAndTurnLeft() throws Exception {
        turnLeft();
        if (frontIsClear()) {
            if (beepersPresent()) {
                move();
                turnLeft();
                move();
            }
            else {
                move();
                turnLeft();
            }

        }

    }

    /**
     * Karel put beepers in one along the row
     * @throws Exception
     */
    private void putBeepersInLine() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            move();
            if (frontIsClear()) {
                move();
                if (frontIsBlocked()) {
                    putBeeper();
                }
            }
        }
    }
}
