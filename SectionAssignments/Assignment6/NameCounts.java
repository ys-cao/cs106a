/** 
 * File: NameCounts.java
 * ---------------------
 * Prompt user to enter name and return
 * with the name and counts.
 */
 
import acm.program.*;
import java.util.*;

public class NameCounts extends ConsoleProgram {
    public void run() {
        readNames();
        printNamesAndCounts();
    }
    
    private void readNames() {
        Map<String, Integer> names = new HashMap<String, Integer>();
        while (true) {
            String enterName = readLine("Enter Name: ");
            if (enterName.equals("")) break;
            if (names.containsKey(enterName)) {
                int count = names.get(enterName)++;
                name.put(enterName, count);
            } else {
                names.put(enterName, 1);
            }
        }
        return names;
    }
    
    private void printNamesAndCounts() {
        for (String name: names.keySet()) {
            int count = names.get(name);
            println("Entry [" + name + "] has count" + count);
        }
    }
}
