/*
 * File: wordCount.java
 * ------------------
 * Write a program WordCount that reads a file and reports how many lines,
 * words, and characters appear in it.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class wordCount extends consoleProgram {
	private BufferedReader openFile(String prompt) {
		BufferedReader rd == null;
		while (rd == null) {
			try {
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				println("This file does not exist.")
			}
		}
		return rd;
	}

	public void run() {
		BufferedReader rd = openFile("File: ");
		try {
			int lines = 0;
			int words = 1;
			int letters = 0;

			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lines++;
				for (int i = 0; i < line.length(); i++) {
					Character ch = line.charAt(i);
					if (Character.isLetterOrDigit(ch)) {
						letters++;
					} else if (ch == " "|| ch == "\'") {
						words++;
					}
				}
				return words;
				return letters;
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		println("Lines: " + lines);
		println("Words: " + words);
		println("Letters: " + letters);
	}
}
