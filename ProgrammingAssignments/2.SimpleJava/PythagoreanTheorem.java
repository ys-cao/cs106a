/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter the values to compute pythagorean Theorem.");
		int a = readInt("a: ");
		int b = readInt("b: ");
		double c = (double) Math.sqrt(a * a + b * b);
		println("c: " + c);
	}
}
