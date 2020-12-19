/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int sentinelValue = 0;
	public void run() {
		println("This program finds the largest and smallest numbers.");
		// Check first enter value.
		int firstNumber = readInt("?");
		if (firstNumber == sentinelValue) {
			println("Invalid value.")
		} else {
			findRange();
		}
		// Run the loop and find smallest and largest until o.
		private int findRange() {
			int smallest = firstNumber;
			int largest = firstNumber;
			while (x != sentinelValue) {
				int x = readInt("?");
				if (x == sentinelValue) {
					println("smallest: " + smallest);
					println("largest: " + largest);
				} else {
					if (x < smallest) {
						smallest = x;
					} else (x > largest) {
						largest = x;
					}
				}
			}
		}
	}
}

