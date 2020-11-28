import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;

/**
 * CSVFileChooser Class
 * @author Junghwan (Kevin) Park
 * CSE360-70605 Final Project
 * <p>
 * This class creates and displays the scatter plot GUI for the plot data function.
 * Scatter plot shows number of students per percentage of the class time attended.
 */

public class ScatterPlot extends JFrame {
	
	/*
	 * Constructor. Creates scatter plot GUI
	 * @param title String that diplays as the title of the plot
	 */
	public ScatterPlot(String title) {
	    super(title);
	    
	     XYDataset dataset = createDataset();	// Get data
	    
	    // Create scatter plot from JFreeChart
	    JFreeChart chart = ChartFactory.createScatterPlot(
	        "Attendance", "Percent of Attendance", "Count", dataset);

	    // Change background color of plot
	    XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(new Color(255,228,196));
	    
	    // Set x-axis range
	    NumberAxis domain = (NumberAxis)plot.getDomainAxis();
        domain.setRange(-5, 105);
        domain.setTickUnit(new NumberTickUnit(10));
        domain.setVerticalTickLabels(true);
        
        // Set y-axis range
        NumberAxis range = (NumberAxis)plot.getRangeAxis();
        range.setRange(0, Repository.roster.size() + 0.5);
        range.setTickUnit(new NumberTickUnit(1));
        range.setVerticalTickLabels(true);
	    
	    // Create panel to display plot
	    ChartPanel panel = new ChartPanel(chart);
	    setContentPane(panel);
	}

	/*
	 *  Create data from repository attendance
	 *  @return dataset Object containing data set
	 */
	private XYDataset createDataset() {
		// List to hold all dates in the roster
		List<LocalDate> dates = new ArrayList<LocalDate>();
		
		// Read dates from header list 
		for(int i = 6; i < Repository.headers.size(); i++) {
			dates.add(LocalDate.parse(Repository.headers.get(i)));
		}
		
		// Create data set
	    XYSeriesCollection dataset = new XYSeriesCollection();
		
	    // For each date, find the data points
		for(LocalDate date : dates) { 
			List<Double> xAxis = Main.repo.getDataSet(date);
			XYSeries classData = new XYSeries(date.toString());
			
			for(int i = 0; i < xAxis.size(); i++) { 
				int percentage = xAxis.get(i).intValue();
				int count = 1;
				
				// Count the number of duplicates
				for(int j = i + 1; j < xAxis.size(); j++) {
					if(percentage == xAxis.get(j).intValue()) {
						count++;
						xAxis.remove(j);
						j--;
					}
				}
				classData.add(percentage, count); 
			}
			dataset.addSeries(classData); 	// Add data set for each date
		}

	    return dataset;
	}
	
	/**
	 * Displays the scatter plot with all the data
	 */
	public static void scatterPlotGUI() {
		SwingUtilities.invokeLater(() -> {
		      ScatterPlot sp = new ScatterPlot("Plot Data");
		      sp.setSize(800, 400);
		      sp.setLocationRelativeTo(null);
		      sp.setVisible(true);
		    });
	}
}
