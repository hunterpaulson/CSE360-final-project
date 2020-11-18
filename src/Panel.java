

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * Panel Class
 * @author 
 * CSE360-70605 Final Project
 * <p>
 * This is the main Panel under the JMenu that displays the JTable of all the data
 */
@SuppressWarnings("serial")
public class Panel extends JPanel implements Observer {
    
	protected JTable table;

    public Panel() {
//    	String[] columnNames = {"Name", "Color"};
//        Object[][] data = { {"John", "Blue"}, {"Oliver", "Green"}, {"Paul", "Red"} };
    	this.table = new JTable();
    	add(new JScrollPane(table));
//    	this.table.setModel(new DefaultTableModel(data, columnNames));
    }
    
    
    /**
     * Sets the value of the drawable object and repaints the JPanel
     * @param o Observable object that notified this plotPanel observer
     * @param arg Object passed by notifyObservers() 
     */
    @Override
    public void update(Observable o, Object arg) {
    	System.out.println("Was Notified");
    	String[][] data = ((Repository)o).getTableData();
    	String[] headers = ((Repository)o).getHeaders();
    	for(String[] arr : data) {
    		System.out.println(Arrays.toString(arr));
    	}
    	System.out.println(Arrays.toString(Repository.headers.toArray()));
    	this.table.setModel(new DefaultTableModel(data, headers));
    	System.out.println("Set Model");
    }
}