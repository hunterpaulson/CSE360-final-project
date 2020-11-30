import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Display Class
 * CSE360-70605 Final Project 
 * <p>
 * Displays the about tab and dialogue boxes to display status or errors
 * 
 * @author Junghwan (Kevin) Park 
 */
public class Display {

    /**
     * Displays error dialogue when the user trys to perform an action on the roster when the roster
     * hasnt been loaded
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
     * Displays the result of adding the attendance data to the roster. Tells how many students the
     * data was loaded for, and if additional attendees were found
     *
     * @param additionalStudents
     * @param studentsAdded
     */
    public void displayAttendanceResult(
            LinkedHashMap<String, Integer> additionalStudents, int studentsAdded) {
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, "Attendance Results");
        
        String loadedMessageText = "Data loaded for " + studentsAdded + " users in the roster.";
        
        String additionalMessageText =  "<html>" + additionalStudents.size()  + " additional attendee(s) was found:<br>";
        
        JPanel panel = new JPanel();
        JLabel loadedMessage =
                new JLabel(loadedMessageText);
        JLabel additionalMessage =
                new JLabel(additionalMessageText);

        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        
        
        panel.setLayout(new FlowLayout());
        panel.add(loadedMessage);
        panel.add(additionalMessage);

        String attendeeMessage = "";

        if (!additionalStudents.isEmpty()) {
            for (Map.Entry<String, Integer> e : additionalStudents.entrySet()) {
                attendeeMessage = "<html>" + e.getKey() + ", connected for " + e.getValue() + " minute(s)" + "<br></br>";
                JLabel additionalLabel = new JLabel(attendeeMessage);
                panel.add(additionalLabel);
            }
        }

        
        
        
        //JScrollPane scrollPane = new JScrollPane(panel);
        dialog.add(new JScrollPane(panel));
        //scrollPane.setSize(400, 600);
        
        //scrollPane.setVisible(true);
        
        
        dialog.setSize(600, 400);
        //dialog.pack();
        dialog.setVisible(true);
        
        Repository.additionalStudents.clear();
        Repository.studentsAdded = 0;
    }

    /** 
     * Displays the team info when the about tab is pressed 
     */
    public void displayTeamInfo() {
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, "About");
        JPanel panel = new JPanel();
		
        
        String teamInfo = "<html> <style>html {text-align: center} html {word-wrap: break-word} </style>" +
                "<h1>CSE360 (#0605)<br></h1>"
                        + "<h2>Members:<br></h2>"
                        + "<h3>Hunter Paulson, Yasser Mountasir Dbeis, Aidan Morgan,\n"
                        + "Junghwan Park, Darshan Vamathevan</h3>"
                        + "</html>";
        JLabel teamInfoLabel = new JLabel(teamInfo);

        panel.add(teamInfoLabel);
        dialog.add(panel);
        
        
        
        dialog.setSize(900, 250);
        dialog.setVisible(true);
    }
}
