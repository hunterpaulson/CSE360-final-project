import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class ScatterPlot extends JFrame {
	
	public ScatterPlot(String title) {
	    super(title);
	    
	     XYDataset dataset = createDataset();	// Get data
	    
	    JFreeChart chart = ChartFactory.createScatterPlot(
	        "Attendance", "Percent of Attendance", "Count", dataset);

	    //Changes background color
	    XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(new Color(255,228,196));
	    
	    NumberAxis domain = (NumberAxis)plot.getDomainAxis();
        domain.setRange(-5, 105);
        domain.setTickUnit(new NumberTickUnit(10));
        domain.setVerticalTickLabels(true);
        
        NumberAxis range = (NumberAxis)plot.getRangeAxis();
        range.setRange(0, Repository.roster.size() + 0.5);
        range.setTickUnit(new NumberTickUnit(1));
        range.setVerticalTickLabels(true);
	    
	    // Create Panel
	    ChartPanel panel = new ChartPanel(chart);
	    setContentPane(panel);
	}

	private XYDataset createDataset() {
		List<LocalDate> dates = new ArrayList<LocalDate>();
		
		for(int i = 6; i < Repository.headers.size(); i++) {
			dates.add(LocalDate.parse(Repository.headers.get(i)));
		}
		
	    XYSeriesCollection dataset = new XYSeriesCollection();
		
		for(LocalDate date : dates) { 
			List<Double> xAxis = Main.repo.getDataSet(date);
			XYSeries classData = new XYSeries(date.toString());
			
			for(int i = 0; i < xAxis.size(); i++) { 
				int percentage = xAxis.get(i).intValue();
				int count = 1;
				
				for(int j = i + 1; j < xAxis.size(); j++) {
					if(percentage == xAxis.get(j).intValue()) {
						count++;
						xAxis.remove(j);
						j--;
					}
				}
				classData.add(percentage, count); 
			}
			dataset.addSeries(classData); 
		}

	    return dataset;
	}
	
	public static void scatterPlotGUI() {
		SwingUtilities.invokeLater(() -> {
		      ScatterPlot sp = new ScatterPlot("Plot Data");
		      sp.setSize(800, 400);
		      sp.setLocationRelativeTo(null);
		      sp.setVisible(true);
		    });
	}
}
