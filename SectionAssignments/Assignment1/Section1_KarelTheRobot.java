/*
 * File: section1_KarelTheRobot.java
 * --------------------------------
 * Section Handout #1—Karel the Robot
 *
 * Karel’s job is to move across the punch card ballot and make sure
 * that no stray bits of the card remain in any of the ballot spaces
 * in which the user has attempted to cast a vote.
 */

import stanford.karel.*;

public class BallotKarel extends SuperKarel {
    public void run() {
        while (frontIsClear()) {
            move();
            checkAndCollect();
        }
    }

/* Check if there is beeper in the middle. If yes, move on. Otherwise, check and colleck all beepers.
 * Pre-condition: standing on the middle of the beeper facing east.
 * Post-condition: standing in front of the next ballot rectangle facing east.
*/
    private void checkAndCollect() {
        if (beeperPresent()) {
            move();
        } else {
            collectBeepers();
            move();
        }
    }

/* Colleck all beepers in this rectangle.
 * Pre-condition: standing on the middle of the beeper facing east.
 * Post-condition: same.
*/
    private void collectBeeper() {
        collectTop();
        collectBottom();
    }

/* Collect top beeper.
 * Pre-condition: standing on the middle of the beeper facing east.
 * Post-condition: standing on the middle and facing south.
*/
    private void collectTop() {
        turnLeft();
        move();
        while (beeperPresent()) {
            pickBeeper();
        }
        turnAround();
         move();
    }

/* Collect bottom beeper.
 * Pre-condition: standing on the middle of the beeper facing south.
 * Post-condition: standing on the middle and facing east.
*/
    private void collectBottom() {
        move();
        while (beeperPresent()) {
            pickBeeper();
        }
        turnAround();
         move();
         turnRight();
    }

}
