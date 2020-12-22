/*
 * File: RubberBanding.java
 * ------------------------
 * Write a GraphicsProgram that allows the user to draw lines on the canvas. Pressing the
 * mouse button sets the starting point for the line. Dragging the mouse moves the other
 * endpoint around as the drag proceeds. Releasing the mouse fixes the line in its current
 * position and gets ready to start a new line.
 * Cite: solution from Stanford.
 */

import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;

public class RubberBanding extends GraphicsProgram {
    public void run() {
        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        line = new Gline(x, y, x, y);
    }

    public void mouseDragged(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        line.setEndPoint(x, y);
    }

    // Private instance variables.
    private GLine line;
}
