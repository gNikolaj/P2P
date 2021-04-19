package com.shpp.p2p.cs.ngrishchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

/*
    TODO: Karel put beeper in the center of line
 */
public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {
        putFirstBeepers();
        fillTheRow();
        turnAround();
        pickAllBeepers();
    }

    /**
     * Karel picks all excess beepers
     * @throws Exception
     */
    private void pickAllBeepers() throws Exception {
        while (frontIsClear()) {
            pickBeeper();
            move();
        }
        pickBeeper();
    }

    /**
     * Karel fills the row with beepers and stop at the last one
     * the last beeper situated in the center of bottom row
     * @throws Exception
     */
    private void fillTheRow() throws Exception {
        while (frontIsClear()) {
            move();
            checkBeeper();
        }
    }

    /**
     * Karel puts beepers until it reaches the center,
     * while checking if there is a beeper on the cage
     * If beeper is present Karel turn around and goes the other way
     * @throws Exception
     */
    private void checkBeeper() throws Exception {
        if (beepersPresent()) {
            turnAround();
            move();
            if (noBeepersPresent()) {
                putBeeper();
                move();
                if (beepersPresent()) {
                    turnAround();
                    move();
                    putBeeper();
                    while (frontIsClear()) {
                        move();
                    }
                }
            }
        }
    }

    /**
     * Karel start with one beeper in the beginning and in the ending of the bottom line
     * @throws Exception
     */
    private void putFirstBeepers() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
        }
        putBeeper();
        turnAround();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
