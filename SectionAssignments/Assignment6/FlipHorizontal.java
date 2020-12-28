/*
 * File: FlipHorizontal.java
 * ------------------
 * Write a method flipHorizontal that works similarly to the flipVertical method
 * presented in the chapter except that it reverses the picture in the horizontal dimension.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

public class FlipHorizontal extends GraphicsProgram {
	public void run() {
		GImage image = new GImage("Milkmaid.gif");
		GImage flipImage = flipImageHorizontally(image);

		add(image, 0, 0);
		add(flipImage, image.getWidth(), image.getHeight());
	}

	/* Create a horizontally flip version of the image. */
	private GImage flipImageHorizontally(GImage image) {
		int[][] array = new image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		/* Flip the pixels based on the center line. */
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width / 2; j++) {
				int temp = int[i][j];
				int[i][j] = int[i][width - j - 1];
				int[i][width - j - 1]= int temp;
			}
		}
		return new GImage(array);
	}
}
