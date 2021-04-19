package com.shpp.p2p.cs.ngrishchenko.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Breakout extends WindowProgram {

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** The amount of time to pause between frames (48fps). */
    private static final double PAUSE_TIME = 1000.0 / 48;

    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Number of all bricks */
    private static final int ALL_BRICKS = NBRICK_ROWS * NBRICKS_PER_ROW;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Diameter of the ball*/
    private static final int BALL_SIZE = BALL_RADIUS * 2;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;

    @Override
    /**
     * mouse listener (when mouse move)
     * when mouse move, paddle takes its coordinates
     * x - paddle position
     * y - paddle position
     */
    public void mouseMoved(MouseEvent mouseEvent) {
        double x = mouseEvent.getX() - (PADDLE_WIDTH / 2.0);
        double y = getHeight() - PADDLE_Y_OFFSET - PADDLE_WIDTH;
        if (mouseEvent.getX() >= getWidth() - (PADDLE_WIDTH / 2)) {
            x = getWidth() - PADDLE_WIDTH;
        }
        if (mouseEvent.getX() <= getWidth() - (getWidth() - (PADDLE_WIDTH / 2))) {
            x = 0;
        }
        paddle.setLocation(x, y);
    }

    private GRect paddle;
    private double vx, vy = 3;
    private int bricksCounter = ALL_BRICKS;
    private int livesCounter = NTURNS;

    public void run() {
        paddle = makePaddle();
        add(paddle);

        GOval ball = makeBall();
        add(ball);

        buildBricks();

        waitForClick();
        addMouseListeners();
        ballMoving(ball);
    }

    /**
     * cycle for game
     * vx - speed and trajectory
     * vy - speed and trajectory
     * rgen - random generator for vx trajectory
     * @param ball - the main ball
     */
    private void ballMoving(GOval ball) {
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.5, 3.0);
        if (rgen.nextBoolean(0.5))
            vx = -vx;
        while (bricksCounter != 0 || livesCounter != 0) {
            checkBottomWall(ball);
            vx = checkRightWall(ball);
            vx = checkLeftWall(ball);
            vy = checkBricks(ball);
            vy = checkTopWall(ball);
            vy = checkPaddle(ball);
            ball.move(vx, vy);
            pause(PAUSE_TIME);
        }
    }

    /**
     * method when player lose tries to win game
     */
    private void loseGame() {
        removeAll();
        loseLabel();
        waitForClick();
    }

    /**
     * label when player lose game
     */
    private void loseLabel() {
        GLabel label = new GLabel("You lose!", getWidth() / 2.0 - 64, getHeight() / 2.0);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setColor(Color.RED);
        add(label);
    }

    /**
     * method when player brake all bricks
     */
    private void winGame() {
        removeAll();
        winLabel();
        waitForClick();
    }

    /**
     * label when player win game
     */
    private void winLabel() {
        GLabel label = new GLabel("You win!", getWidth() / 2.0 - 64, getHeight() / 2.0);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setColor(Color.GREEN);
        add(label);
    }

    /**
     * checks if brick present delete brick and bounce ball
     * brickCounter - counts how many bricks left to win the game
     * @param ball - main ball
     * @return vy trajectory
     */
    private double checkBricks(GOval ball) {
        GObject brick;
        if (getElementAt(ball.getX(), ball.getY()) != null && ball.getY() < getHeight() / 2.0) {
            brick = getElementAt(ball.getX(), ball.getY());
            remove(brick);
            vy = -vy;
            bricksCounter--;
        } else if (getElementAt(ball.getX() + BALL_SIZE, ball.getY()) != null && ball.getY() < getHeight() / 2.0) {
            brick = getElementAt(ball.getX() + BALL_SIZE, ball.getY());
            remove(brick);
            vy = -vy;
            bricksCounter--;
        } else if (getElementAt(ball.getX(), ball.getY() + BALL_SIZE) != null && ball.getY() < getHeight() / 2.0) {
            brick = getElementAt(ball.getX(), ball.getY() + BALL_SIZE);
            remove(brick);
            vy = -vy;
            bricksCounter--;
        } else if (getElementAt(ball.getX() + BALL_SIZE, ball.getY() +  BALL_SIZE) != null && ball.getY() < getHeight() / 2.0) {
            brick = getElementAt(ball.getX() + BALL_SIZE, ball.getY() + BALL_SIZE);
            remove(brick);
            bricksCounter--;
        }
        if (bricksCounter == 0) {
            winGame();
        }
        return vy;
    }

    /**
     * checks if paddle present - bounce ball
     * @param ball - main ball
     * @return vy trajectory
     */
    private double checkPaddle(GOval ball) {
        if (ball.getX() + BALL_SIZE >= paddle.getX()
                && ball.getX() <= paddle.getX() + PADDLE_WIDTH
                && ball.getY() + BALL_SIZE >= paddle.getY()
                && ball.getY() < paddle.getY() + PADDLE_WIDTH / 2.0) {
            if (vy > 0) {
                return -vy;
            }
        }
        return vy;
    }

    /**
     * check if ball drops down - minus live or lose game
     * ballX - ball position
     * ballY - ball position
     * paddleX - paddle position
     * paddleY - paddle position
     * livesCounter - count tries to lose the game
     * @param ball - main ball
     */
    private void checkBottomWall(GOval ball) {
        double ballX = getWidth() / 2.0 - BALL_RADIUS;
        double ballY = getHeight() - PADDLE_Y_OFFSET - PADDLE_WIDTH - BALL_SIZE;
        double paddleX = getWidth() / 2.0 - (PADDLE_WIDTH / 2.0);
        double paddleY = getHeight() - PADDLE_Y_OFFSET - PADDLE_WIDTH;

        if (ball.getY() >= getHeight()) {
            livesCounter--;
            if (livesCounter == 0) {
                loseGame();
            }
            ball.setLocation(ballX, ballY);
            paddle.setLocation(paddleX, paddleY);
            waitForClick();
        }
    }

    /**
     * bounce from top wall
     * @param ball - main ball
     * @return vy trajectory
     */
    private double checkTopWall(GOval ball) {
        if (ball.getY() <= 0) {
            return -vy;
        }
        return vy;
    }

    /**
     * bounce from left wall
     * @param ball - main ball
     * @return vx trajectory
     */
    private double checkLeftWall(GOval ball) {
        RandomGenerator rgen = RandomGenerator.getInstance();
        if (ball.getX() <= 0) {
            vx = rgen.nextDouble(-1.0, -3.0);
            return -vx;
        }
        return vx;
    }

    /**
     * bounce from right wall
     * @param ball - main ball
     * @return vx trajectory
     */
    private double checkRightWall(GOval ball) {
        RandomGenerator rgen = RandomGenerator.getInstance();
        if (ball.getX() + BALL_SIZE >= getWidth()) {
            vx = rgen.nextDouble(1.0, 3.0);
            return -vx;
        }
        return vx;
    }

    /**
     * build matrix of bricks
     * give colours for bricks
     * x - brick position
     * y - brick position
     * color - color to paint row of bricks
     */
    private void buildBricks() {
        double x = (getWidth() -((BRICK_SEP + BRICK_WIDTH) * NBRICKS_PER_ROW) + BRICK_SEP) / 2.0 - 1 ;
        double y = BRICK_Y_OFFSET;
        Color color = Color.BLACK;

        for (int i = 0; i < NBRICK_ROWS; i++) {
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                switch (i) {
                    case 0:
                        color = Color.red;
                        break;
                    case 2:
                        color = Color.ORANGE;
                        break;
                    case 4:
                        color = Color.yellow;
                        break;
                    case 6:
                        color = Color.green;
                        break;
                    case 8:
                        color = Color.blue;
                        break;
                }
                makeOneBrick(x, y, color);
                x = x + BRICK_SEP + BRICK_WIDTH;
            }
            x = (getWidth() -((BRICK_SEP + BRICK_WIDTH) * NBRICKS_PER_ROW) + BRICK_SEP) / 2.0 - 1;
            y = y + BRICK_HEIGHT + BRICK_SEP;
        }

    }

    /**
     * create brick
     * @param x - brick position
     * @param y - brick position
     * @param color - brick color
     */
    private void makeOneBrick(double x, double y, Color color) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFillColor(color);
        brick.setFilled(true);
        add(brick);
    }

    /**
     * create paddle
     * x - paddle position
     * y - paddle position
     * @return created paddle
     */
    private GRect makePaddle() {
        double x = getWidth() / 2.0 - (PADDLE_WIDTH / 2.0);
        double y = getHeight() - PADDLE_Y_OFFSET - PADDLE_WIDTH;

        GRect paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFillColor(Color.BLACK);
        paddle.setFilled(true);
        return paddle;
    }

    /**
     * create ball
     * x - ball position
     * y - ball position
     * @return created ball
     */
    private GOval makeBall() {
        double x = getWidth() / 2.0 - BALL_RADIUS;
        double y = getHeight() - PADDLE_Y_OFFSET - PADDLE_WIDTH - BALL_SIZE;

        GOval ball = new GOval(x, y, BALL_SIZE, BALL_SIZE);
        ball.setFillColor(Color.BLUE);
        ball.setFilled(true);
        return ball;
    }
}