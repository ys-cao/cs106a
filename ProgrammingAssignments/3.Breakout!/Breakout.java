/*
 * File: Breakout.java
 * -------------------
 *
 * Get some ideas from https://gist.github.com/NatashaTheRobot/1375730
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

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

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;

    // Private instance variables for the velocities of the ball.
    private double vx, vy;

    // Declare an instance variable rgen which will serve as a random-number generator.
    private RandomGenerator rgen = RandoGenerator.getInstance();

    // Animation delay or pause time between ball moves
    private static final int DELAY = 50;

    // Private instance variable for paddle.
    private GRect paddle;

    // Constant of number of bricks.
    private int brickCounter = 100;

    // Private instance variable for ball.
    private GOval ball;

    /* Method: run() */
    /** Runs the Breakout program. */
    public void run() {
        // This will remains the condition when start next turn.
        createBricks();
        for (int n = 0; n < NTURNS; n++) {
            createPaddle();
            createBall();
            playGame();
            if (brickCounter == 0) {
                printWinner();
            } else {
                continue;
            }
        }

        // After three turns and there is still brick, game over.
        if (brickCounter > 0) {
            printGameOver();
        }
    }

    // Draw bricks.
    private void createBricks() {
        // Draw rows.
        for (int i = 1; i <= NBRICK_ROWS; i++) {
            // Set up int brick_y for brick y coordination.
            double brick_y = BRICK_Y_OFFSET + (i - 1) * BRICK_HEIGHT;
            // Draw bricks in each row.
            for (int j = 1; j <= NBRICKS_PER_ROW / 2; j ++) {
                double brick_x_right = WIDTH / 2.0 + BRICK_SEP / 2.0 + (BRICK_WIDTH + BRICK_SEP) * (j - 1);
                double brick_x_left = WIDTH / 2.0 - BRICK_SEP / 2.0 - BRICK_WIDTH - (BRICK_WIDTH + BRICK_SEP) * (j - 1);
                // Draw right half row of bricks.
                drawHalfRowBricks(brick_x_right, brick_y, i);
                // Draw left half row of bricks.
                drawHalfRowBricks(brick_x_left, brick_y, i);
            }
        }
    }

    // Draw the half row of the bricks.
    private GRect drawHalfRowBricks(double x, double y, int i) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        add(brick);
        brick.setFilled(true);
        if (i == 1 || i == 2) {
            brick.setColor(Color.RED);
        } else if (i == 3 || i == 4) {
            brick.setColor(Color.ORANGE);
        } else if (i == 5 || i == 6) {
            brick.setColor(Color.YELLOW);
        } else if (i == 7 || i == 8) {
            brick.setColor(Color.GREEN);
        } else if (i == 9 || i == 10) {
            brick.setColor(Color.CYAN);
        }
    }

    // Create a paddle and set it to track the mouse horizontally only.
    private void createPaddle() {
        addMouseListeners();
        paddle = new GRect(WIDTH / 2 - PADDLE_WIDTH / 2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
        add(paddle);
        paddle.setFilled(true);
    }

    // Called on when mouse moves to get the X point.
    public void mouseMoved(MouseEvent e) {
        // e.getX() is at the middle of the paddle.
        // This range is to make sure the mouse is within the window.
        if (e.getX() >= PADDLE_WIDTH / 2 && e.getX() <= WIDTH - PADDLE_WIDTH / 2) {
            paddle.setLocation(mouse_x, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
        }
    }

    // Create the ball starting at the middle position and random direction (downside).
    // Create the function of bouncing.
    private void createBall() {
        // Create the shape of the ball.
        double X_START = WIDTH / 2.0 - BALL_RADIUS;
        double Y_START = HEIGHT / 2.0 - BALL_RADIUS;
        ball = new GOval(X_START, Y_START, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        add(ball);
    }

    // Run the game.
    private void playGame() {
        waitForClick();
        while (true) {
            moveBall();
            checkForCollision();
            pause(DELAY);
            if (ball.getY() >= HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET || brickCounter == 0) {
                break;
            }
    }

    // Update and move the ball.
    private void moveBall() {
        // Initialize the vx and vy variable.
        vx = rgen.nextDouble(1.0, 3.0);
        vy = 3.0;
        // Set vx negative half the time.
        if (rgen.nextBoolen(0.5)) vx = -vx;
        ball.move(vx, vy);
    }

    // Determine if collision with walls, paddles or bricks. Update velocities and locations.
    private void checkForCollision() {
        // Check for walls.
        if (ball.getX() + vx <= 0) {
            vx = -vx;
            double diff = -ball.getX();
            ball.move(-2 * diff, 0);
        } else if (ball.getX() + 2 * BALL_RADIUS + vx >= WIDTH) {
            vx = -vx;
            double diff = ball.getX() - (WIDTH - 2 * BALL_RADIUS);
            ball.move(-2 * diff, 0);
        } else if (ball.getY() - vy <= 0) {
            vy = -vy;
            double diff = -ball.getY();
            ball.move(0, -2 * diff);
        }

        //Check for collision with objects.
        GObject collider = getCollisionObject();
        if (collider == paddle) {
            /* To avoid ball stick to the side of the paddle.
             * It's less unlikely the bottom of the ball hits the top of the paddle at the same height.
             * The vy is 3. We can treat the bottom of the ball to be within the top of the paddle and 
             * the top of the paddle minus 3 area as ball hits the paddle.
             */
            if (ball.getY() <= HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET - 2 * BALL_RADIUS &&
            ball.getY() > HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET - 2 * BALL_RADIUS - 3) {
                vy = -vy;
            }
        } else if (collider == brick) {
            vy = -vy;
            remove(collider);
            brickCounter --;
        }
    }

    // Check what object is when there is a collision.
    private GObject getCollisionObject() {
        // The current location of ball.
        double x = ball.getX();
        double y = ball.getY();
        // Check for all four exterior points for the ball.
        if (getElementAt(x, y) != null) {
            return getElementAt(x, y);
        } else if (getElementAt(x, y + 2 * BALL_RADIUS) != null) {
            return getElementAt(x, y + 2 * BALL_RADIUS);
        } else if (getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS) != null) {
            return getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS);
        } else if (getElementAt(x + 2 * BALL_RADIUS, y) != null) {
            return getElementAt(x + 2 * BALL_RADIUS, y);
        } else {
            return null;
        }
    }

    // Print winner.
    private void printWinner() {
        GLabel winner = new GLabel("You Win!", WIDTH / 2, HEIGHT / 2);
        add(winner);
    }

    // Print game over.
    private void printWinner() {
        GLabel gameOver = new GLabel("Game Over!", WIDTH / 2, HEIGHT / 2);
        add(gameOver);
    }
}
