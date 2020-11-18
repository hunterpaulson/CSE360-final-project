import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.time.LocalDate; // import the LocalDate class
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

@SuppressWarnings("deprecation")
public class Repository extends Observable  {
	
	public static List<Student> roster;
	public static List<String> headers;
	
	public static final String delimiter = ",";
	
	public Repository() {
		headers = new ArrayList();
	}
	
	
	public void read(String csvFile) {
		 List<Student> studentList = new ArrayList();
		 
		 try {
			 
	        File file = new File(csvFile);
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        
	        String line = "";
	        String[] studentAttributes;
	        
	        line = br.readLine();
        	studentAttributes = line.split(delimiter);
        		
	        if(studentAttributes[0].equals("ID")) {	        	
	        	for(int i = headers.size(); i < studentAttributes.length; i++) {
	        		headers.add(studentAttributes[i]);
	        	}
	        }
	        else {
	            studentList.add(createStudent(studentAttributes));
	        }
	        
	        while((line = br.readLine()) != null) {
	        	studentAttributes = line.split(delimiter);
	            studentList.add(createStudent(studentAttributes));
	        }
	        
	        br.close();
	        
         } catch(IOException ioe) {
            ioe.printStackTrace();
         }
		 
		 roster = studentList;
	}
	
	
	public void load(String csvInputFile) {
		
		System.out.println(Arrays.toString(Repository.headers.toArray()));
		this.read(csvInputFile);
		System.out.println("Read File");
		setChanged();
		notifyObservers();
		System.out.println("Tried to Notify");
	}
	   
	/*
	* createStudent takes in an array of strings, 
	* each entry corresponding to an attribute of
	* the student read in a line of the input csv.
	* The method will use these attributes to 
	* construct a Student object and return it as stu.
	* 
	* @param attributes String[]
	* @return Student
	* 
	*/
	   public Student createStudent(String[] attributes) {
		   String ID = attributes[0];			
		   String firstName = attributes[1];
		   String lastName = attributes[2];
		   String program = attributes[3];
		   String level = attributes[4];
		   String ASURITE = attributes[5];
		   
		   Student stu = new Student(ID, firstName, lastName, program, level, ASURITE);
		   for(int i = 6; i < attributes.length; i++) {
			   stu.addAttendance(LocalDate.parse(headers.get(i)), Integer.parseInt(attributes[i]));
		   }
		   
		   return stu;
	   }
	   
	   public void save(String saveFilePath) {
		   
		   //Save Dialog Code to be used somewhere else and resulting filepath to be passed into this function
		   JFrame parentFrame = new JFrame();
		   
		   JFileChooser fileChooser = new JFileChooser();
		   fileChooser.setDialogTitle("Save Roster");   
		    
		   int userSelection = fileChooser.showSaveDialog(parentFrame);
		   File fileToSave = null;
		   if (userSelection == JFileChooser.APPROVE_OPTION) {
		       fileToSave = fileChooser.getSelectedFile();
		       System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		   }
		   
		   try {
			FileWriter csvWriter = new FileWriter(fileToSave.getAbsolutePath().toString());
			
			if(!headers.isEmpty())
				csvWriter.append(String.join(",", headers));
			
			List<List<String>> tableData = getTableData();
			
			for(List<String> studentInfo : tableData) {
				csvWriter.append("\n");
				csvWriter.append(String.join(",", studentInfo));
			}
			
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   
		   
	   }
	   
	   
	   public String[][] getTableData() {
		   
		   String[][] tableData = new String[roster.size()][];
		    
		   for(int i = 0; i < roster.size(); i++) {
			   String[] stuAttributes = new String[headers.size()];
			   stuAttributes[0] = roster.get(i).getID();
			   stuAttributes[1] = roster.get(i).getFirstName();
			   stuAttributes[2] = roster.get(i).getLastName();
			   stuAttributes[3] = roster.get(i).getProgram();
			   stuAttributes[4] = roster.get(i).getLevel();
			   stuAttributes[5] = roster.get(i).getASURITE();
			   
			   int j = 6;
			   for(Map.Entry<LocalDate, Integer> e : roster.get(i).getAttendance().entrySet()) {
				   stuAttributes[j] = Integer.toString(e.getValue());
				   j++;
			   }
			   
			   tableData[i] = stuAttributes;
		   }
		   
		   return tableData;
	   }
}






