import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 * Main Class
 * @author Hunter Paulson, ADD YOUR NAME HERE IF YOU CONTRUBUTE
 * CSE360-70605 Final Project
 * <p>
 * 
 */
@SuppressWarnings("serial")  // remove this before we submit, its just annoying
public class Main extends JFrame {
		
	protected static Repository repo;
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
        
        
        
        Panel panel = new Panel();
        add(panel);
        
        
        repo = new Repository();
        repo.addObserver(panel);
        
        // Action listeners
        loadRoster.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	String inputFilepath = Controller.getOpenPath();
            	Controller.loadTable(inputFilepath);
//            	Controller.loadTable("C:\\Users\\hwp11\\OneDrive\\Documents\\Classes\\CSE360\\studentTest.csv");
                
                // The controller validates the given input, and
                // eventually calls some methods on the Model,
                // possibly using the given input values
//                controller.process(s, i, d);
            }
        });
        
        addAttendance.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		if(Repository.roster != null) {		// Check if roster has been loaded
		        	String inputFilepath = Controller.getOpenPath();
		        	if(inputFilepath != null) {		// Check if file could be found
		        		Controller.displayDatePicker(inputFilepath);
		        	}
        		}
        		else {
        			Controller.displayEmptyRosterError();		// Display error if roster has not been loaded yet
        		}
        	}
        });
        
        saveRoster.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String inputFilepath = Controller.getSavePath();
                // TODO: need to handle if they dont choose a filepath
                Controller.saveTable(inputFilepath);
            }
        });

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
