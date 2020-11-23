import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.LocalDate;

/**
 * Controller Class
 * @author 
 * CSE360-70605 Final Project
 * <p>
 * The controller manages user interaction and passes these interactions to the view (main/panel) and the model(repository)
 */
public class Controller {

	public static String getOpenPath() {
		return new CSVFileChooser().getOpenFile().getAbsolutePath().toString();
	}
	
	public static String getSavePath() {
		return new CSVFileChooser().getSaveFile().getAbsolutePath().toString();
	}
	
	public static void loadTable(String filepath) {
        Main.repo.load(filepath);
	}
	
	// in controller
    public static void saveTable(String filepath) {
        if (Main.repo.save(filepath)) {
             // show success in display class
        } else {
            // give error message in display class
        }
    }
	
	// Prompt user to select date of attendance
	public static void displayDatePicker(String filepath) {
        DatePicker calendar = new DatePicker();
        calendar.datePickerGUI(filepath);
    }
    
	// Save date and time from file into attendance data
    public static void saveDate(int month, int day, int year, String filepath) {
    	LocalDate date = LocalDate.of(year,  month, day);
    	Main.repo.addStudentAttendance(date, filepath);

    	// Display JDialog with added info
    	Display dis = new Display();
    	dis.displayAttendanceResult(Repository.additionalStudents, Repository.studentsAdded);
    }
    
    // Display error for when the roster has not been loaded
    public static void displayEmptyRosterError() {
    	Display dis = new Display();
    	dis.emptyRosterErrorHandler();
    }
    
    public static void displayScatterPlot() {
    	ScatterPlot.scatterPlotGUI();
    } 
}
