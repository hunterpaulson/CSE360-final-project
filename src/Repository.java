import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.time.LocalDate; // import the LocalDate class
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

@SuppressWarnings("deprecation")
public class Repository extends Observable  {
	
	public static List<Student> roster;
	public static List<String> headers;
	private static int numTimesLoaded = 0;
	
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
	        
	        if(numTimesLoaded != 0) {	        	
	        	line = br.readLine();
	        	studentAttributes = line.split(delimiter);
	        	for(int i = headers.size(); i < studentAttributes.length; i++) {
	        		headers.add(studentAttributes[i]);
	        	}
	        }
	        
	        while((line = br.readLine()) != null) {
	        	studentAttributes = line.split(delimiter);
	            studentList.add(createStudent(studentAttributes));
	        }
	        
	        br.close();
	        
         } catch(IOException ioe) {
            ioe.printStackTrace();
         }
		 
		 this.roster = studentList;
		 numTimesLoaded++;
	}
	   public void load() {

		 final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		 int returnVal = fc.showOpenDialog(null);
		 
		 List<Student> students;
		 
		 if(returnVal == JFileChooser.APPROVE_OPTION) {
			 File csvInputFile = fc.getSelectedFile();
			 Repository repo = new Repository();
			 repo.read(csvInputFile.toString());
			 students = repo.roster;

			 setChanged();
			 notifyObservers();
		 }
		
	   }
	   
	   public Student createStudent(String[] attributes) {
		   String ID = attributes[0];
		   String firstName = attributes[1];
		   String lastName = attributes[2];
		   String program = attributes[3];
		   String level = attributes[4];
		   String ASURITE = attributes[5];
		   
		   
		   LocalDate currDate = LocalDate.now();
		   
		   Student stu = new Student(ID, firstName, lastName, program, level, ASURITE);
		   stu.addAttendance(currDate, 10);
		   for(int i = 6; i < attributes.length; i++) {
			   stu.addAttendance(LocalDate.parse(headers.get(i)), Integer.parseInt(attributes[i]));
		   }
		   
		   return stu;
	   }
	   
	   public void save() {
		   
	   }
	   
	   
	   public List<List<String>> getTableData() {
		   
		   List<List<String>> tableData = new ArrayList(roster.size());
		    
		   for(int i = 0; i < roster.size(); i++) {
			   List<String> stuAttributes = new ArrayList();
			   stuAttributes.add(roster.get(i).getID());
			   stuAttributes.add(roster.get(i).getFirstName());
			   stuAttributes.add(roster.get(i).getLastName());
			   stuAttributes.add(roster.get(i).getProgram());
			   stuAttributes.add(roster.get(i).getLevel());
			   stuAttributes.add(roster.get(i).getASURITE());
			   
			   for(Map.Entry<LocalDate, Integer> e : roster.get(i).getAttendance().entrySet()) {
				   stuAttributes.add(Integer.toString(e.getValue()));
			   }
			   
			   tableData.add(stuAttributes);
		   }
		   
		   return tableData;
	   }
}






