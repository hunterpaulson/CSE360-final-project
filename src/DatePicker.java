import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * DatePicker Class
 * CSE360-70605 Final Project
 * <p>
 * This class creates the date picker GUI as a part of the add attendance function.
 * 
 * @author Junghwan (Kevin) Park 
 */
public class DatePicker {

    /**
     * Create and display GUI for date picker
     *
     * @param filepath path to csv file with attendance data
     */
    public void datePickerGUI(String filepath) {
        JFrame frame = new JFrame("Calendar");
        JPanel panel = new JPanel();
        JButton button = new JButton("Confirm");
        JLabel label = new JLabel("Select date of attendance:");

        frame.setBounds(250, 250, 250, 100);

        // Initialize new date picker from JXDatePicker
        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("MM/dd/yyyy")); // Specify date format

        // Add elements to frame
        panel.add(label);
        panel.add(picker);
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Handle button press
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Date selectedDate = picker.getDate(); // Store selected date as an object
                        int inputMonth = selectedDate.getMonth() + 1;
                        int inputDay = selectedDate.getDate();
                        int inputYear = selectedDate.getYear() + 1900;

                        // Call controller function to save date into student object
                        Controller.saveDate(inputMonth, inputDay, inputYear, filepath);
                        frame.dispose(); // Close date picker GUI
                    }
                });
    }
}
