package com.shpp.p2p.cs.ngrishchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

/*
    TODO: Karel moves to beeper(newspaper),
        take it and returns to the start position
 */

public class Assignment1Part1 extends KarelTheRobot {

    public void run() throws Exception {
        goToNewspaper();
        pickBeeper();
        goToStartPosition();
    }

    /**
     * Karel turn around and moves to start position
     * @throws Exception
     */
    private void goToStartPosition() throws Exception {
        turnAround();
        goStraight();
        turnRight();
        move();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /**
     * Karel moves till find newspaper
     * @throws Exception
     */
    private void goToNewspaper() throws Exception {
        goStraight();
        turnRight();
        move();
        turnLeft();
        goStraight();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Karel moves straight to wall or till find beeper
     * @throws Exception
     */
    private void goStraight() throws Exception {
        while (frontIsClear() && noBeepersPresent()) {
            move();
        }
    }
}
