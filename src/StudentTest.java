import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	
	// Student object to be used in each test case to test Student Class
	private static Student student;

	/**
	 * Creates student object with default values before each test to
	 * test each method.
	 */
	@BeforeEach
	void createStudent() {
		this.student = new Student("123456789",
								   "TestFirstName",
								   "TestLastName",
								   "TestProgram",
								   "TestLevel",
								   "987654321");
	}
	
	/**
	 * Adds the local date as an entry twice to check
	 * if the add attendance creates an entry and 
	 * updates its value if same date is given.
	 */
	@Test
	void addAttendance() {
		LocalDate ld = LocalDate.now();
		student.addAttendance(ld, 1);
		student.addAttendance(ld, 1);		
		assertEquals(student.getDateAttendance(ld), 2);
	}
	
	/**
	 * Checks if date entry is added succesffuly and can 
	 * be retrieved. 
	 */
	@Test
	void getDateAttendance() {
		LocalDate ld = LocalDate.now();
		student.addAttendance(ld, 32);
		assertEquals(student.getDateAttendance(ld), 32);
	}
	
	/**
	 * Checks if entire hashmap 
	 * returned as the attendance
	 * is correct value wise.
	 */
	@Test
	void getAttendance() {
		LocalDate ld = LocalDate.now();
		student.addAttendance(ld, 32);
		
		Map<LocalDate, Integer> testAttendance = new HashMap<>();
		testAttendance.put(ld, 32);
		
		assertEquals(student.getAttendance(), testAttendance);
	}
	
	/**
	 * Checks if ID is retrievable.
	 */
	@Test
	void getID() {
		assertEquals(student.getID(), "123456789");
	}
	
	/**
	 * Checks if ID can be updated
	 * and verifies updated value.
	 */
	@Test
	void setID() {
		student.setID("4444");
		assertEquals(student.getID(), "4444");
	}
	
	/**
	 * Checks if correct first name is retrievable.
	 */
	@Test
	void getFirstName() {
		assertEquals(student.getFirstName(), "TestFirstName");
	}
	
	/**
	 * Checks if first name can be updated
	 * and verifies updated value.
	 */
	@Test
	void setFirstName() {
		student.setFirstName("Yasser");
		assertEquals(student.getFirstName(), "Yasser");
	}
	
	/**
	 * Checks if correct last name is retrievable.
	 */
	@Test
	void getLastName() {
		assertEquals(student.getLastName(), "TestLastName");
	}
	
	/**
	 * Checks if last name can be updated
	 * and verifies updated value.
	 */
	@Test
	void setLastName() {
		student.setLastName("Dbeis");
		assertEquals(student.getLastName(), "Dbeis");
	}
	
	/**
	 * Checks if correct program is retrievable.
	 */
	@Test
	void getProgram() {
		assertEquals(student.getProgram(), "TestProgram");
	}
	
	/**
	 * Checks if program can be updated
	 * and verifies updated value.
	 */
	@Test
	void setProgram() {
		student.setProgram("TestProgram2");
		assertEquals(student.getProgram(), "TestProgram2");
	}
	
	/**
	 * Checks if correct level is retrievable.
	 */
	@Test
	void getLevel() {
		assertEquals(student.getLevel(), "TestLevel");
	}
	
	/**
	 * Checks if level can be updated
	 * and verifies updated value.
	 */
	@Test
	void setLevel() {
		student.setLevel("TestLevel2");
		assertEquals(student.getLevel(), "TestLevel2");
	}
	
	/**
	 * Checks if correct ASURITE is retrievable.
	 */
	@Test
	void getASURITE() {
		assertEquals(student.getASURITE(), "987654321");
	}
	
	/**
	 * Checks if ASURITE can be updated
	 * and verifies updated value.
	 */
	@Test
	void setASURITE() {
		student.setASURITE("7777777");
		assertEquals(student.getASURITE(), "7777777");
	}
	
	
}


