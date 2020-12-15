/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
    
    public void run() {
        turnLeft();
        while (frontIsClear()) {
            repairColumn():
            moveToNextColumn();
        }
    }
    
    private void repairColumn () {
        while (frontIsClear()) {
            checkStone();
            move();
        }
        checkStone();
    }
    
    private void checkStone() {
        if (noBeepersPresent) {
            putBeeper();
        }
    }
    
    private void moveToNextColumn() {
        if (facingNorth()) {
            turnRight();
            moveFourTimes();
            turnRight();
        }
        else if (facingSouth()) {
            turnLeft();
            moveFourTimes();
            turnLeft();
        }
    }
    
    private void moveFourTimes() {
        move();
        move();
        move();
        move();
    }
}
