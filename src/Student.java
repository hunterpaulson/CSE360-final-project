import java.time.LocalDate;
import java.util.HashMap;

public class Student {
	
	private HashMap<LocalDate, Integer> attendance;
	private String ID;
	private String firstName;
	private String lastName;
	private String program;
	private String level;
	private String ASURITE;
	
	public Student(String ID, String firstName, String lastName, String program, String level, String ASURITE) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.program = program;
		this.level = level;
		this.ASURITE = ASURITE;
		this.attendance = new HashMap();
	}
	
	public void addAttendance(LocalDate date, int time) {
		attendance.put(date, attendance.getOrDefault(date, 0) + time);
	}
	
	public int getAttendance(LocalDate date) {
		return attendance.get(date);
	}
	
	
	public HashMap<LocalDate, Integer> getAttendance() {
		return new HashMap(attendance);
	}
	
	public String getID() {
		return this.ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getASURITE() {
		return this.ASURITE;
	}
	
	public void setASURITE(String ASURITE) {
		this.ASURITE = ASURITE;
	}
	
}