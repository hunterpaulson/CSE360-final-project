import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * Panel Class
 * @author Hunter Paulson, Aidan Morgan
 * CSE360-70605 Final Project
 * <p>
 * This is the main Panel under the JMenu that displays the JTable of all the data
 */
public class Panel extends JPanel implements Observer {
    
	protected JTable table;

	/**s
	 * Constructor for Panel class.
	 * Adds a scroll pane with a JTable inside of it to the JPanel
	 */
    public Panel() {
    	this.table = new JTable();
    	add(new JScrollPane(table));
    }
    
    
    /**
     * Sets the value of the drawable object and repaints the JPanel
     * @param o Observable object that notified this plotPanel observer
     * @param arg Object passed by notifyObservers() 
     */
    @Override
    public void update(Observable o, Object arg) {
    	String[][] data = ((Repository)o).getTableData();
    	String[] headers = ((Repository)o).getHeaders();
    	System.out.println(Arrays.toString(Repository.headers.toArray()));
    	for(String[] arr : data) {
    		System.out.println(Arrays.toString(arr));
    	}
    	this.table.setModel(new DefaultTableModel(data, headers));
    }
}