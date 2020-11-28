import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepositoryTest {
	
	private Repository repo;
	
	/**
	 * Reads and Loads Repo data from test roster csv
	 * so that the data in repo can be used before
	 * every test.
	 */
	@BeforeEach
	void loadRepo() {
        File rosterFile = new File("TestRoster.csv");        // TestRoster.csv contains the test input data
        repo = new Repository();
        repo.read(rosterFile.getAbsolutePath().toString());    // Read TestRoster.csv and create repository for it
	}
	
	/**
	 * Creates a student object and checks if
	 * it's attributes are correct and accessible.
	 */
	@Test 
	void createStudent() {
		String[] studentAttributes = {"123", "Yasser", "Dbeis", "TestProgram",	// Outline attributes of student
				"TestLevel", "321"};
		
		Student stu = repo.createStudent(studentAttributes);			// call function to create student
		
		assertEquals(stu.getID(), "123");				
		assertEquals(stu.getFirstName(), "Yasser");
		assertEquals(stu.getLastName(), "Dbeis");
		assertEquals(stu.getProgram(), "TestProgram");
		assertEquals(stu.getLevel(), "TestLevel");
		assertEquals(stu.getASURITE(), "321");
	}
	
	/**
	 * Save returns true if the roster was able to be 
	 * saved as a csv with no exceptions or errors.
	 */
	@Test
	void save() {
		boolean successfulSave = repo.save("test.csv");
		assertEquals(successfulSave, true);
	}
	
	/**
	 * After the repo is loaded, check
	 * if the headers contain the correct
	 * values.
	 */
	@Test
	void getHeaders() {
		
		String[] headers = repo.getHeaders();	//retrieve headers
		
		assertEquals(headers[0], "ID");	// check equality
		assertEquals(headers[1], "First Name");
		assertEquals(headers[2], "Last Name");
		assertEquals(headers[3], "Program");
		assertEquals(headers[4], "Level");
		assertEquals(headers[5], "ASURITE");
		assertEquals(headers[6], "2020-11-26");
		
	}
	
	/**
	 * After the repo is loaded, check
	 * if the table data returned was
	 * converted to the 2D String array
	 * correctly and in the correct order.
	 */
	@Test
	void getTableData() {
		String[][] tableData = repo.getTableData();	//retrieve converted table data
		
		assertEquals(Arrays.toString(tableData[0]), "[1234123, Kevin, Park, Computer Science, Graduate, jpark310, 0]");
		assertEquals(Arrays.toString(tableData[1]), "[24241, Aidan, Aidan, Computer Science, Undergraduate, aidan20, 25]");
		assertEquals(Arrays.toString(tableData[2]), "[424221, Hunter, Hunter, Computer Science, Undergraduate, hunter420, 45]");
		assertEquals(Arrays.toString(tableData[3]), "[34646, Yasser, Yasser, Computer Science, Graduate, yasser83, 75]");
		assertEquals(Arrays.toString(tableData[4]), "[12355, Darshan, Darshan, Computer Science, Graduate, darshan49, 120]");
		
	}
	
	/**
	 * Adds student attendance from file (3 new entries)
	 * and check if the ASURITE ID and time of attendance
	 * was correctly loaded and accessible. 
	 */
	@Test
	void addStudentAttendance() {
		LocalDate ld = LocalDate.now();								//load attenance file using today's date
		repo.addStudentAttendance(ld, "Attendance.csv");

		assertEquals(repo.roster.get(0).getASURITE(), "jpark310");	//checks if student entries have correct ASURITE
		assertEquals(repo.roster.get(1).getASURITE(), "aidan20");
		assertEquals(repo.roster.get(2).getASURITE(), "hunter420");
		
		assertEquals(repo.roster.get(0).getDateAttendance(ld), 35);	//check if loaded student entries have correct time of attendance
		assertEquals(repo.roster.get(1).getDateAttendance(ld), 200);
		assertEquals(repo.roster.get(2).getDateAttendance(ld), 22);

	}
	
	/**
	 * Checks if after loading an attendance file,
	 * the repo has the date contained within it. 
	 */
	@Test
	void hasDate() {
		LocalDate ld = LocalDate.now();
		repo.addStudentAttendance(ld, "Attendance.csv");	// load attendance file using today's date
		
		assertEquals(repo.hasDate(LocalDate.now()), true);	// check if it has date
	}
	
    /**
     * Test the getDataSet() function used to create the scatter plot. 
     * Ensures data point values are correct. 
     */
	@Test
    void getDataSetTest() {
        List<Double> actual = new ArrayList<Double>();        // Actual scatter plot data calculated using getDataSet()
        List<Double> expected = new ArrayList<Double>();    // Expected scatter plot data based on what is inputed

        LocalDate date = LocalDate.of(2020, 11, 26);        // Date corresponding to date within TestRoster.csv

        actual = repo.getDataSet(date);

        // Expected data outputs
        expected.add(0.0 / 75 * 100);
        expected.add(25.0 / 75 * 100);
        expected.add(45.0 / 75 * 100);
        expected.add(100.0);
        expected.add(100.0);

        assertEquals(expected, actual);
    }
	
	
}


