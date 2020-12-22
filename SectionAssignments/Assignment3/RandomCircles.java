/*
 * File: RandomCircles.java
 * ------------------------
 * Write a GraphicsProgram that draws a set of ten circles with different sizes, positions,
 * and colors. Each circle should have a randomly chosen color, a randomly chosen radius
 * between 5 and 50 pixels, and a randomly chosen position on the canvas, subject to the
 * condition that the entire circle must fit inside the canvas without extending past the edge.
 */

import acm.util.*;
import acm.graphics.*;
import acm.program.*;

public class RandomCircles extends GraphicsProgram {
    public void run() {
        for (int i = 0; i < numCircles; i++) {
            drawRandomCircles();
        }
    }

    // Set up canvas width and height.
    double canvasWidth = getWidth();
    double canvasHeight = getHeight();

    private void drawRandomCircles() {
        int radius = rgen.nextInt(5, 50);
        int diameter = 2 * radius;
        double x = rgen.nextDouble(0, canvasWidth - diameter); // Circle x point.
        double y = rgen.nextDouble(0, canvasHeight - diameter); // Circle y point.
        GOval randomCircle = new GOval(x, y, diameter, diameter);
        randomCircle.setFilled(true);
        randomCircle.setColor(rgen.nextColor());
        add(randomCircle);
    }

    // Constant number for how many circles.
    private static final int numCircles = 10;

    // Private instance variables generating random values.
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
