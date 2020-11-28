import java.awt.FlowLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Display Class
 * @author Junghwan (Kevin) Park
 * CSE360-70605 Final Project
 * Displays the about tab and dialogue boxes to display status or errors 
 */
public class Display {

	/**
	 * Displays error dialogue when the user trys to perform an action on the roster when the roster hasnt been loaded
	 */
	public void emptyRosterErrorHandler() {
		JFrame frame = new JFrame();
		JDialog dialog = new JDialog(frame, "Error");
		JPanel panel = new JPanel();
		JLabel message = new JLabel("ERROR: Roster must be loaded first");
	        
		panel.add(message);
	    dialog.add(panel);
	        
	    dialog.setSize(300, 70);
	    dialog.setVisible(true);
	}
	
	/**
	 * Displays the result of adding the attendance data to the roster.
	 * Tells how many students the data was loaded for, and if additional attendees were found
	 * @param additionalStudents
	 * @param studentsAdded
	 */
	public void displayAttendanceResult(LinkedHashMap<String, Integer> additionalStudents, int studentsAdded) {
		JFrame frame = new JFrame();
		JDialog dialog = new JDialog(frame, "Attendance Results");

	    JPanel panel = new JPanel();
		JLabel loadedMessage = new JLabel("Data loaded for " + studentsAdded + " users in the roster.");
	    JLabel additionalMessage = new JLabel(additionalStudents.size() + " additional attendee(s) was found:\n");
			    
	    //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    panel.setLayout(new FlowLayout());
		panel.add(loadedMessage);
		panel.add(additionalMessage);

		String attendeeMessage = "";
		
	    if(!additionalStudents.isEmpty()) {
	    	for(Map.Entry<String, Integer> e : additionalStudents.entrySet()) {
	    		  attendeeMessage = e.getKey() + ", connected for " + e.getValue() + " minute(s)\n";
	    		  JLabel additionalLabel = new JLabel(attendeeMessage);
	  	    	  panel.add(additionalLabel);	    
	    	}
	    }
	        
	    dialog.add(panel);
	    //dialog.setSize(300);
	    dialog.pack();
	    dialog.setVisible(true);
	    
	    Repository.additionalStudents.clear();
	    Repository.studentsAdded = 0;
		
	}
	
	/**
	 * Displays the team info when the about tab is pressed
	 */
	public void displayTeamInfo() {
		JFrame frame = new JFrame();
		JDialog dialog = new JDialog(frame, "Error");
		JPanel panel = new JPanel();
		
		String teamInfo = 
				"CSE360 (#0605)\n\n" +
				"Members:\n" +
				"Hunter Paulson, Yasser Mountasir Dbeis, Aidan Morgan,\n" +
				"Junghwan Park, Darshan Vamathevan";
		JLabel teamInfoLabel = new JLabel(teamInfo);
	        
		panel.add(teamInfoLabel);
	    dialog.add(panel);
	        
	    dialog.setSize(400, 200);
	    dialog.setVisible(true);
	}
	
	
}
