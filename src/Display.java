import java.awt.FlowLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Display {

	public void emptyRosterErrorHandler() {
		JFrame frame = new JFrame();
		JDialog dialog = new JDialog(frame, "Error");
	    JLabel message = new JLabel("ERROR: Roster must be loaded first");
	        
	    dialog.add(message);
	        
	    dialog.setSize(300, 80);
	    dialog.setVisible(true);
	}
	
	public void displayAttendanceResult(LinkedHashMap<String, Integer> additionalStudents, int studentsAdded) {
		JFrame frame = new JFrame();
		JDialog dialog = new JDialog(frame, "Attendance Results");
	    JLabel loadedMessage = new JLabel("Data loaded for " + studentsAdded + " users in the roster.");
	    
	    dialog.add(loadedMessage);
	    
	    if(!additionalStudents.isEmpty()) {
	    	String additionalMessage = additionalStudents.size() + " additional attendee(s) was found:\n";
	    	for(Map.Entry<String, Integer> e : additionalStudents.entrySet()) {
	    		  additionalMessage += e.getKey() + ", connected for " + e.getValue() + " minute(s)\n";
	    		  JLabel additionalLabel = new JLabel(additionalMessage);
	    		  dialog.add(additionalLabel);
	    	}
	    }
	        
	    dialog.setSize(300, 80);
	    dialog.setVisible(true);
		
	}
	
	
}
