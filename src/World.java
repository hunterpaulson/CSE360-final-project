

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * World Class
 * @author Hunter Paulson 
 * CSE360-70605 Assignment 03
 * <p>
 * The world class has the main method and runs the program. 
 * World has-a Source object (Aggregation).
 * World() also consists of 3 plotPanels (SimplePlot, MarkedPlot and BarPlot) and
 * 1 "Run" Button. The world is the acitonListener for the runButton.
 */
public class World extends JFrame implements ActionListener {
    
	private Source source;
	
	/**
	 * Constructor for the World class
	 * Initialized the layout of the JFrame as a FlowLayout
	 * so that each of the three plot panels can use their preferred size.
	 * 
	 */
    public World() {
        SimplePlot simplePlot = new SimplePlot();
        MarkedPlot markedPlot = new MarkedPlot();
        BarPlot barPlot = new BarPlot();

        // a marked plot has a underlying simplePlot
        markedPlot.add(simplePlot);
        // a bar plot has a underlying markedPlot
        barPlot.add(markedPlot);

        // 3 PlotPanels, one of each type
        PlotPanel simplePlotPanel = new PlotPanel(simplePlot);
        simplePlotPanel.setPreferredSize(new Dimension(400, 270));
        PlotPanel markedPlotPanel = new PlotPanel(markedPlot);
        markedPlotPanel.setPreferredSize(new Dimension(400, 270));
        PlotPanel barPlotPanel = new PlotPanel(barPlot);
        barPlotPanel.setPreferredSize(new Dimension(400, 270));

        
        source = new Source();
        source.addObserver(simplePlotPanel);
        source.addObserver(markedPlotPanel);
        source.addObserver(barPlotPanel);

        setLayout(new FlowLayout());
        
        JButton runButton = new JButton("Run");
        runButton.addActionListener(this);        
        add(barPlotPanel);
        add(markedPlotPanel);
        add(simplePlotPanel);
        add(runButton);
    }

    /**
     * Main function that initializes the JFrame World, sets its size, 
     * sets its close operation, and makes it visible
     * @param args String array of arguments passed to the program as it is run
     */
    public static void main(String[] args) {
        World world = new World();
        world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        world.setSize(460, 900);
        world.setVisible(true);
    }

	/**
	 * When the runButton is clicked, the World acts as an actionListener
	 * and calls this function.
	 * This function uses the source object to create a random value, and 
	 * then repaints the JFrame
	 */
    public void actionPerformed(ActionEvent e) {
    	source.create();
    	repaint();
    }
}

