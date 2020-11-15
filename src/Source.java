

import java.util.Observable;

/**
 * Source Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * Source is Observable as part of the Observer pattern.
 * Every time that the user clicks the button "Run" 
 * source.create() is called to create a random number from 0 to 250 and 
 * to notify its Observers
 */
public class Source extends Observable {

    private int value;

	/**
	 * Called by the source object when the action listener
	 * for the button is activated.
	 * Creates a random variable between 0 and 250,
	 * and then notifies its three observers 
	 */
    public void create() {
        int min = 0;
        int max = 250;
        value = (int) (Math.random() * (max - min + 1) + min);
        setChanged();
        notifyObservers();
    }

    /**
     * Getter for the value that was randomly generated in create()
     * Used by PlotPanel.update() to set the value of the drawable
     * @return the value that was randomly generated in Source.create()
     */
    public int getValue() { 
        return value; 
    }

    
}