

import java.awt.*;

/**
 * MarkedPlot Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * Uses the linked list of values inherited from Drawable to
 * create a plot with squares marking the points
 */
public class MarkedPlot extends DecoratedPlot {
    
	/**
	 * Draws a plot with filled in squares to mark each point
	 * @param g Graphics object that is drawn onto the JPanel
	 */
    @Override
    public void draw(Graphics g) {
    	
    	int spacing = 20;
    	int squareWidth = 10;
    	
    	g.setColor(Color.BLACK);
        
    	if (values.size() != 0) {
    		for (int index = 0; index < values.size(); index++) {
    			g.fillRect(
    					(index * spacing) - (squareWidth / 2), 
    					values.get(index) - (squareWidth / 2), 
    					squareWidth, 
    					squareWidth
    			);
    		}    		
    	}
    	drawable.draw(g);
    }
}
