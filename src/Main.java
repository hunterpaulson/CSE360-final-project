import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 */

/**
 * Main Class
 * @author Hunter Paulson, ADD YOUR NAME HERE IF YOU CONTRUBUTE
 * CSE360-70605 Final Project
 * <p>
 * 
 */
public class Main extends JFrame {
	
	/**
	 * 
	 */
	public Main()
	{   
        // Layout 
        setLayout(new FlowLayout()); // set this to whatever works best
        
        // Menu
        // Use JMenu here for the 'File' and 'About' menu items
        JMenuItem loadRoster = new JMenuItem("Load a Roster");
        JMenuItem addAttendance = new JMenuItem("Add Attendance");
        JMenuItem saveRoster = new JMenuItem("Save");
        JMenuItem plotData = new JMenuItem("Plot Data");
        
        // add the menuItems to file
        JMenu file = new JMenu("File");
        file.add(loadRoster);
        file.add(addAttendance);
        file.add(saveRoster);
        file.add(plotData);
        
        // add the menu's to the menu bar
        JMenu about = new JMenu("About");
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(about);
        
        add(menuBar);
        setJMenuBar(menuBar);
        
        
        // Table
        // Use JTable here
        // in theJTable we need a JScrollPane with horizontal and vertical scroll bars
        
        

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(500, 500);
        main.setVisible(true);

	}

}
