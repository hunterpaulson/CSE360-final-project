
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * CSV File Chooser Class
 * @author Aidan Morgan,
 * CSE360-70605 Final Project
 * The CSVFileChooser 
 */
public class CSVFileChooser extends JFileChooser {

	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");
	final Dimension prefered = new Dimension();
	
	public CSVFileChooser() {
		chooser.setFileFilter(filter);
		chooser.setApproveButtonText("Add Attendance");
		chooser.setBackground(Color.WHITE);
		chooser.setForeground(Color.white);
		prefered.setSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2.25, Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2.25);
		chooser.setPreferredSize(prefered);
		
	}
	
	public File getOpenFile()
	{
		//int returnVal = chooser.showOpenDialog(getParent());
		File file;
		int returnVal = chooser.showOpenDialog(getParent());
		file = chooser.getSelectedFile();
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = file.getName();
			if(!fileName.substring(fileName.lastIndexOf('.')).equals(".csv"))
			{
				file = null;
			}
		}
		else {
			file = null;
		}
		
		return file;
		
	}
	
	public File getSaveFile()
	{
		//int returnVal = chooser.showOpenDialog(getParent());
		File file;
		int returnVal = chooser.showSaveDialog(getParent());
		file = chooser.getSelectedFile();
		
		if(returnVal != JFileChooser.APPROVE_OPTION) {
			file = null;
		}
		
		return file;
		
	}
}
