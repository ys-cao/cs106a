
/*
 * File: Histograms.java
 * ------------------
 * Write a program that reads a list of exam scores from the file
 * MidtermScores.txt (which contains one score per line) and
 * then displays a histogram of those numbers, divided into the
 * ranges 0–9, 10–19, 20–29, and so forth, up to the range
 * containing only the value 100.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class Histograms extends ConsoleProgram {
	public void run() {
		initScoresArray();
		readFile();
		printHistogram();
	}

	/* Initialize the ScoresArray */
	private initScoresArray() {
		scoresArray = new int[11];
		for (int i = 0; i < 11; i++) {
			scoresArray[i] = 0;
		}
	}

	/* Read scores from MidtermScores.txt and update scoresArray */
	private readFile() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("MidtermScores.txt"));
			while (true) {
				String line = rd.readline();
				if (line == null) break;
				int score = (int) line;
				if (score < 0 || score > 100) {
					thorw new ErrorException("Invalid score.");
				} else {
					int index = score / 10;
					scoresArray[index]++;
				}
			}
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	/* Print out the scoresArray as Histogram with stars. */
	private void printHistogram() {
		for (int i = 0; i < scoresArray.length; i++) {
			String stars = createStars(scoresArray[i]);
			if (i == scoresArray.length - 1) {
				println("  100: " + stars)
			}
			println(i * 10 + '-' + i * 10 + 9 + ": " + stars);
		}
	}

	/* Create stars based on scoresArray. */
	private String createStars(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += "*";
		}
		return result;
	}

	/* Private instance variables */
	private int[] scoresArray;
}
