

import java.awt.*;

/**
 * DecoratedPlot Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * Implements the decorator pattern
 * Allows us to add both the MarkedPlot and the BarPlot as decorators for the
 * SimplePlot.
 */
public abstract class DecoratedPlot extends Drawable {
    
    protected Drawable drawable; 

    /**
     * Adds the current plot Object as a decorator for the plot that
     * is passed as a parameter
     * @param d Drawable object that this plot decorates
     */
    public void add(Drawable d) { 
        drawable = d; 
    }

    /**
     * Calls the setValue function of the parent class Drawable
     * @param value Integer that the value is being set to
     */
    @Override
    public void setValue(int value) {
        super.setValue(value);
    }

    /**
     * Implemented differently for each of the two plots that inherit this class
     * @param g Graphics object that is drawn onto the JPanel
     */
    public void draw(Graphics g) { 

    }
}
