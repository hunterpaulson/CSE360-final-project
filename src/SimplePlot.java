

import java.awt.*;

/**
 * SimplePlot Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * Uses the linked list of values inherited from Drawable to
 * create a plot with lines drawn between adjacent points
 */
public class SimplePlot extends Drawable {
    
	/**
	 * Draws a plot with lines between adjacent points in the values list
	 * @param g Graphics object that is drawn onto the JPanel
	 */
    @Override
    public void draw(Graphics g) {
    	
        g.setColor(Color.BLACK);
        
        int spacing = 20;

    	if (values.size() > 1) {
    		for (int index = 1; index < values.size(); index++) {
    			int behind = index - 1;
    			// draw a line from the point behind to the current point
    			g.drawLine(
    					behind * spacing, 
    					values.get(behind), 
    					index * spacing, 
    					values.get(index)
    			);
    		}
    	}
    	super.draw(g);
    	
    }
}
