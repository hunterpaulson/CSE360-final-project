

import java.awt.*;

/**
 * BarPlot Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * Uses the linked list of values inherited from Drawable to
 * create a plot with Bars from the bottom of the plot to the points
 */
public class BarPlot extends DecoratedPlot {
    
	/**
	 * Draws a plot with gray bars from the base of the JPanel to the point 
	 * @param g Graphics object that is drawn onto the JPanel
	 */
    @Override
    public void draw(Graphics g) {
    	
    	int spacing = 20;
    	int maxValue = 250;
    	int barWidth = 10;
    	
    	if (values.size() != 0) {
    		g.setColor(Color.GRAY);
    		for (int index = 0; index < values.size(); index++) {
    			g.fillRect(
    					(index * spacing) - (barWidth / 2), 
    					values.get(index), 
    					barWidth, 
    					maxValue - values.get(index)
    			);
    		}
    	}
    	drawable.draw(g);
    }
}
