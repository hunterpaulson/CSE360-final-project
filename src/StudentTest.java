import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void test() {

	   Repository repo = new Repository();
	   
	   repo.load();
	   
		 for(Student stu : repo.roster) {
			System.out.println("ID: " + stu.getID() + 
							   " First Name: " + stu.getFirstName() + 
							   " Last Name: " + stu.getLastName() + 
							   " Level: " + stu.getLevel() + 
							   " ASURITE: " + stu.getASURITE() +
							   " Attendance: " + LocalDate.now().toString() + " : " + stu.getAttendance(LocalDate.now()));  
		 }
	}

}


