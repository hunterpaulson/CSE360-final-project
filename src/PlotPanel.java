

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * PlotPanel Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * There are 3 plotPanels, each with their own Drawable object,
 * PlotPanel observes the source class,
 * When notified that a new value is created by the Source object 
 * it reads the value and passes it to its drawable object and repaints the JPanel
 */
public class PlotPanel extends JPanel implements Observer {
    
	Drawable drawable;

	/**
	 * Constructor for the PlotPanel Class
	 * @param drawable the drawable object that this panel displays
	 */
    public PlotPanel(Drawable drawable) {
        this.drawable = drawable;
    }

    /**
     * Sets the value of the drawable object and repaints the JPanel
     * @param o Observable object that notified this plotPanel observer
     * @param arg Object passed by notifyObservers() 
     */
    @Override
    public void update(Observable o, Object arg) {
        drawable.setValue(((Source)o).getValue());
        repaint();
    }

    /**
     * Paints the JPanel if the drawable object is not null
     * Called by repaint()
     * @param g Graphics object that is drawn onto the JPanel
     */
    public void paintComponent(Graphics g) {
        if (drawable != null) {
            drawable.draw(g);
        }
    }
    
}