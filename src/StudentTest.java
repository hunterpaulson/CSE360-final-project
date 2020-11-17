import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void test() {

	   Repository repo = new Repository();
	   
	   repo.load();
	   
	   
	   System.out.println(repo.headers.toString());

		 for(Student stu : repo.roster) {
			System.out.println("ID: " + stu.getID() + 
							   " First Name: " + stu.getFirstName() + 
							   " Last Name: " + stu.getLastName() + 
							   " Level: " + stu.getLevel() + 
							   " ASURITE: " + stu.getASURITE());
			   
			for(Map.Entry<LocalDate, Integer> e : stu.getAttendance().entrySet()) {
				System.out.println("Attendance: " + e.getKey().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + " : " + e.getValue()); 
			}
							    
		 }
		 
		 System.out.println(repo.getTableData().toString());
		 repo.save("foo.txt");
	}

}


