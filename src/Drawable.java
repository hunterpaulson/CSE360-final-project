

import java.awt.*;
import java.util.LinkedList;

/**
 * Drawable Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * Head of the Decorator pattern
 * Contains a linked list of integers that are used to create the plots that 
 * make up the rest of the decorator pattern.
 */
public abstract class Drawable {
    
    protected LinkedList<Integer> values = new LinkedList<Integer>();

    /**
     * Uses head insertion to add a number to the linked list
     * If the linkedList is full then the last node is removed
     * @param v Random value created by the source object
     */
    public void setValue(int v) {
    	int maxListSize = 20;
    	if (values.size() == maxListSize) {
    		values.removeLast();
    	}
        values.addFirst(v);
        
    }

    /**
     * Implemented differently for each of the three plots that inherit this class
     * @param g Graphics object that is drawn onto the JPanel
     */
    public void draw(Graphics g) {
    
    }
}
