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
	  JPanel panel = new JPanel();
		JLabel message = new JLabel("ERROR: Roster must be loaded first");
	        
		panel.add(message);
	    dialog.add(panel);
	        
	    dialog.setSize(300, 70);
	    dialog.setVisible(true);
	}
	
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
	
	
}
