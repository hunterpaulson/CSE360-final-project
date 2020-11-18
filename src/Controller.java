import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Controller Class
 * @author 
 * CSE360-70605 Final Project
 * <p>
 * The controller manages user interaction and passes these interactions to the view (main/panel) and the model(repository)
 */
public class Controller {

	public static String getFilePath() {
		File csvInputFile = null;
		final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnVal = fc.showOpenDialog(null);
		 
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			csvInputFile = fc.getSelectedFile();
		}
		return csvInputFile.toString();
	}
	
	public static void loadTable(String filepath) {
        Main.repo.load(filepath);
	}
}
