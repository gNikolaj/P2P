package com.shpp.p2p.cs.ngrishchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

/*
    TODO: Karel put beepers in empty squares in columns
        if beeper is present, robot don't put beepers
 */

public class Assignment1Part2 extends KarelTheRobot {

    public void run () throws Exception {

        while (frontIsClear()) {
            checkColumn();
            changeColumn();
        }
        checkColumn();
    }

    /**
     * When Karel check column and put beepers
     * move to another column
     * @throws Exception
     */
    private void changeColumn() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    /**
     * Check empty squares to put beepers
     * if beeper is in the square - move
     * @throws Exception
     */
    private void checkColumn() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            checkBeeper();
            move();
        }
        checkBeeper();
        turnAround();
        goStraight();
        turnLeft();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Use this method to return Karel to the first line
     * @throws Exception
     */
    private void goStraight() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void checkBeeper() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }
}
