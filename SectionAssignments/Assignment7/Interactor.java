/**
 * File: Interactor.java
 * ---------------------
 * Section Handout #7: Using Interactors
 */
 
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interactor extends GraphicsProgram {
    
// Initializes the program.
    public void init() {
        contents = new HashMap<String, GObject>();
        
        nameProgram = new JTextField(30);
        nameProgram.addActionListeners(this);
        add(new JLabel("Name", SOUTH));
        add(nameProgram, SOUTH);
        
        addButton = new JButton("Add", SOUTH);
        removeButton = new JButton("Remove", SOUTH);
        clearButton = new JButton("Clear", SOUTH);
        
        add(addButton, SOUTH);
        add(removeButton, SOUTH);
        add(clearButton, SOUTH);
        
        addActionListeners();
        addMouseListeners();
    }
    
// Add box with given name at the center of the window.
    private void addBox(String name) {
        GCompound box = new GCompound();
        GRect rect = new GRect(BOX_WIDTH, BOX_HEIGHT);
        GLabel label = new GLabel(name);
        
        box.add(rect, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
        box.add(label, -label.getWidth() / 2, label.getAscent() / 2);
        add(box, getWidth() / 2, getHeight() /2);
        contents.put(name, box);
    }
    
// Remove box with given name.
    private void removeBox(String name) {
        GObject object = contents.get(name);
        if(object != null) remove(object);
    }
    
// Clear all boxes in the hashmap.
    private void clearBox() {
        for(String name: contents.keySet()) {
            contents.remove(name);
        }
        contents.clear();
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (addButton == source || source == nameProgram) {
            addBox(nameProgram.getText());
        } else if (source == removeButton) {
            removeBox(nameProgram.getText());
        } else if (source == clearButton) {
            clearBox();
        }
    }
    
    public void mousePressed(MouseEvent e) {
        last = new GPoint(e.getPoint());
        currentObject = getElementAt(last);
    }
    
    public void mouseDragged(MouseEvent e) {
        if (currentObject != null) {
            currentObject.move(e.getX() - last.getX(), e.getY() - last.getY());
            last = new GPoint(e.getPoint());
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        if (currentObject != null) currentObject.sendToFront();
    }
    
    // Private constants.
    private static final double BOX_WIDTH = 120;
    private static final double BOX_HEIGHT = 50;
    
    // Private instance variables.
    private JButton addButton;
    private JButton removeButton;
    private JButton clearButton;
    private JTextField nameProgram;
    private HashMap<String, GObject> contents;
    private GObject currentObject;
    private GPoint last;
}
