/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
    public void run() {
        // Single column case.
        if (frontIsBlocked) {
            turnLeft();
            putBeeper();
            while (frontIsClear()) {
                move();
                if (frontIsClear()) {
                    move();
                    putBeeper();
                } else {
                    break;
                }
            }
        } else {
            // The rest cases.
            while (frontIsClear()) {
                fillRow();
            }
        }
    }

    private void fillRow() {
        putBeeper();
        move();
        if (frontIsClear()) {
            move();
            putBeeper();
        } else {
            moveToNextRow();
        }
    }

    private void moveToNextRow() {
        if (facingEast()) {
            turnLeft();
            move();
            turnLeft()
            if (beeperPresent()) {
                move();
            } else if (noBeeperPresent()) {
                putBeeper();
                move();
                move();
            }
        } else if (facingWest()) {
            turnRight();
            move();
            turnRight();
            if (beeperPresent()) {
                move();
            } else if (noBeeperPresent()) {
                putBeeper();
                move();
                move();
            }
        }
    }

}
