/*
 * File: RobotFace.java
 * --------------------
 * Draw a robot face.
 */
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
 
public class RobotFace extends GraphicsProgram {
    // Add all required constants.
    private static final int HEAD_WIDTH = 100;
    private static final int HEAD_HEIGHT = 150;
    private static final int EYE_RADIUS = 15;
    private static final int MOUTH_WIDTH = 80;
    private static final int MOUTH_HEIGHT = 30;
    
    // Draw the face.
    public void run() {
        drawHead();
        drawEyes(x - HEAD_WIDTH / 4, y - HEAD_HEIGHT / 4);
        drawEyes(x + HEAD_WIDTH / 4, y - HEAD_HEIGHT / 4);
        drawMouth();
    }
    
    // Find center points coordination.
    double x = getWidth() / 2;
    double y = getHeight() / 2;
    
    // Draw the head.
    private GRect drawHead() {
        GRect head = new GRect(x - HEAD_WIDTH / 2, y - HEAD_HEIGHT / 2, HEAD_WIDTH, HEAD_HEIGHT);
        head.setFilled(true);
        head.setFillColor(Color.gray);
        return head;
    }
    
    // Draw eyes.
    private void drawEyes(double ex, double ey) {
        GOval eye = new GOval(ex, ey, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
        eye.setFilled(true);
        eye.setColor(Color.yellow);
        add(eye);
    }
    
    // Draw the mouth.
    private void drawMouth() {
        GRect mouth = new GRect(x + MOUTH_WIDTH / 2, y + HEAD_HEIGHT / 4);
        mouth.setFilled(true);
        mouth.setColor(Color.white);
        return mouth;
    }
}




