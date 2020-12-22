/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		// Draw from the top to bottom.
		for (int i = 1; i <= BRICKS_IN_BASE; i++) {
			double y = getHeight() - (BRICKS_IN_BASE + 1 - i) * BRICK_HEIGHT;

			for (int j = i; j > 0; j--) {
				double x = getWidth() / 2 - BRICK_WIDTH * j / 2 + (i - j) * BRICK_WIDTH / 2;
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT));
				add(brick);
			}
		}
}
