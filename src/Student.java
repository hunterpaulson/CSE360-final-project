import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Student Class
 * CSE360-70605 Final Project
 * <p>
 * Represents a Student Entry in the Roster
 * 
 * @author Yasser Dbeis
 */
public class Student {

    // hashmap to map date of attendance to the time the student attended
    private HashMap<LocalDate, Integer> attendance;

    // ID, name, program, level, and ASURITE are all attributes of the student
    private String ID;
    private String firstName;
    private String lastName;
    private String program;
    private String level;
    private String ASURITE;

    /**
     * Parameterized constructor to create the student object
     *
     * @param ID Student's ID
     * @param firstName Student's First Name
     * @param lastName Student's Last Name
     * @param program Student's Program Name
     * @param level Student's Level in School
     * @param ASURITE Student's ASURITE
     */
    public Student(
            String ID,
            String firstName,
            String lastName,
            String program,
            String level,
            String ASURITE) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.level = level;
        this.ASURITE = ASURITE;
        this.attendance = new LinkedHashMap();
    }

    /**
     * Takes in a date and time spent attending on that date and either adds an attendance entry
     * (mapping the date to the time spent) or updates an entry that is already present with the
     * same date by adding to the time.
     *
     * @param date Date of attendance
     * @param time Time spent attending class on that day
     */
    public void addAttendance(LocalDate date, int time) {
        attendance.put(date, attendance.getOrDefault(date, 0) + time);
    }

    /**
     * Gets attendance time for a certain date
     *
     * @param date
     * @return Time spent on that particular date by student attending
     */
    public int getDateAttendance(LocalDate date) {
        return attendance.get(date);
    }

    /**
     * Gets the attendance mapping for the particular student
     *
     * @return Map mapping the dates to the attendance time
     */
    public HashMap<LocalDate, Integer> getAttendance() {
        return new LinkedHashMap(attendance);
    }

    /**
     * Gets the ID of the student
     *
     * @return String value of student's ID
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Updates student's ID
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets student's first name
     *
     * @return String of students first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Updates students first name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets students last name
     *
     * @return String of students last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Updates students last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets students Program
     *
     * @return String value of student's program
     */
    public String getProgram() {
        return program;
    }

    /**
     * Updates student's program name
     *
     * @param program
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * Gets students level
     *
     * @return String value of students level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Updates student's level value
     *
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Gets student's ASURITE
     *
     * @return String value of students ASURITE
     */
    public String getASURITE() {
        return this.ASURITE;
    }

    /**
     * Updates students ASURITE
     *
     * @param ASURITE
     */
    public void setASURITE(String ASURITE) {
        this.ASURITE = ASURITE;
    }
}
