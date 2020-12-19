/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;

		double rOutCircle = 72;
		GOval outCircle = new GOval(x - rOutCircle, y - rOutCircle, rOutCircle, rOutCircle);
		outCircl.setFillColor(Color.red);
		add(outCircle);

		doublee rMidCirle = 72 * 0.65;
		GOval midCircle = new GOval(x - rMidCirle, y - rMidCirle, rMidCirle, rMidCirle);
		midCircl.setFillColor(Color.white);
		add(midCircle);

		double rInnerCirle = 72 * 0.3;
		GOval innerCircle = new GOval(x - rInnerCirle, y - rInnerCirle, rInnerCirle, rInnerCirle);
		innerCircl.setFillColor(Color.red);
		add(innerCircle);
	}
}
