/*
 * File: UniqueNames.java
 * ------------------
 * Write a program that asks the user for a list of names (one per line) until the user enters a
 * blank line (i.e., just hits return when asked for a name). At that point the program should
 * print out the list of names entered, where each name is listed only once (i.e., uniquely) no
 * matter how many times the user entered the name in the program.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram {
	public void run() {
		ArrayList<String> name = new ArrayList<String>();
		while (true) {
			String value = readString("Enter Name: ");
			if (value.equals(SENTINEL)) break;
			for (int i = 0; i < name.size(); i++) {
				/* Iterate the ArrayList and add the value of the name if there is no same name. */
				if (!name.contains(value)) {
					name.add(value);
				}
			}
		}
		printUniqueNames(name);
	}

	/* Print out unique names. */
	private void printUniqueNames(name) {
		println("Unique name list contains: ");
		for (int i = 0; i < name.size(); i++) {
			println(name.get(i));
		}
	}

	/* Private constants */
	private static final String SENTINEL = null;
}
