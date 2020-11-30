import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main Class
 * @author Hunter Paulson, Aidan Morgan, Junghwan (Kevin) Park, Yasser Dbeis, Darshan Vamathevan
 * CSE360-70605 Final Project
 * <p>
 * Acts as the main view for the GUI. Displayed to the user upon startup.
 * When buttons are pressed in the View, Main calls the respective controller functions.
 */
public class Main extends JFrame {
		
	protected static Repository repo;
	
	/**
	 * Constructor for Main class. Sets up the layout and adds JMenuBar and JPanel to it
	 */
	public Main()
	{   
        // Layout 
        setLayout(new BorderLayout()); // set this to whatever works best
        
		Dimension preferred = new Dimension();
		preferred.setSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
		setPreferredSize(preferred);
		
		//JScrollPane
		//final JFrame scrollPane
		
        // Menu
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
        JMenuItem about = new JMenuItem("About");
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(about);
        
        add(menuBar);
        setJMenuBar(menuBar);
        
        setTitle("CSE360 Final Project");
        
        // Roster Panel
        Panel panel = new Panel();
        add(panel, BorderLayout.CENTER);
        
        // Repository
        repo = new Repository();
        repo.addObserver(panel);
        
        
        
       
        // Action listeners
        loadRoster.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	String inputFilepath = Controller.getOpenPath();
            	if(inputFilepath != null) {		// Check if file could be found
            		Controller.loadTable(inputFilepath);
	        	}
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
            	if(Repository.roster != null) {		// Check if roster has been loaded
        			String inputFilepath = Controller.getSavePath();
        			if(inputFilepath != null) {		// Check if file could be found
        				Controller.saveTable(inputFilepath);
        			}
        		}
        		else {
        			Controller.displayEmptyRosterError();
        		}
            }
        });
        
        plotData.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		if(Repository.roster != null) {		// Check if roster has been loaded
        			Controller.displayScatterPlot();
        		}
        		else {
        			Controller.displayEmptyRosterError();
        		}
            }
        });
        
        about.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.displayAboutTab();
            }
        });

	}

	/**
	 * Starts the program and sets up the GUI
	 * @param args
	 */
	public static void main(String[] args) {
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(main.getPreferredSize());
        main.setVisible(true);

	}

}
