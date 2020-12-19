/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	public void run() {
		private static final int boxWidth = 120;
		private static final int boxHeight = 50;

		// Center of the graphic.
		double x = getWidth() / 2;
		double y = getHeight() / 2;

		// Top box.
		double x1 = x - boxWidth / 2;
		double y1 = y - boxHeight / 2 * 3;
		// Bottom left box.
		double x2 = x - boxWidth - boxHeight / 2;
		double y2 = y + boxHeight / 2 * 3;
		// Bottom middle box.
		double x3 = x1;
		double y3 = y2;
		// Bottom right box.
		double x4 = x + boxWidth / 2 + boxHeight / 2;
		double y4 = y2;

		// Draw all four boxes.
		add(new rect(x1, y1));
		add(new rect(x2, y2));
		add(new rect(x3, y3));
		add(new rect(x4, y4));

		// Draw all three lines.
		// Left line.
		add(new Gline(x, y - boxHeight / 2, x1 + boxWidth / 2, y2));
		// Middle line.
		add(new Gline(x, y - boxHeight / 2, x, y2));
		// Right Line.
		add(new Gline(x, y - boxHeight / 2, x4 - boxWidth / 2, y2));

		// Add all four labels from top to bottom and left to right.
		add(new label(x1, y1, "Program"));
		add(new label(x2, y2, "GraphicsProgram"));
		add(new label(x3, y3, "ConsoleProgram"));
		add(new label(x4, y4, "DialogProgram"));

		private GRect box(double x, double y) {
			GRect rect = new GRect(x, y, boxWidth, boxHeight);
			return rect;
		}

		// double x and y is the location of the box.
		private GLabel label(double x, double y, String text) {
			double width = label.getWidth();
			double height = label.getAscent();
			double labelX = x + boxWidth / 2 - width / 2;
			double labelY = y + boxHeight / 2 - height / 2;
			GLabel label = new GLabel(String text, labelX, labelY);
			return laber;
		}
	}
}

