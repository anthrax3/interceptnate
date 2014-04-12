package info.sarihh.interceptnate.samples.mainsample.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import info.sarihh.interceptnate.samples.mainsample.beans.Student;
import info.sarihh.interceptnate.samples.mainsample.daos.DAOService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

/**
 * @author Sari Haj Hussein
 */
public class CallbackInterceptorTest {

	@Test
	public void test() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// add students
		Integer studentID1 = DAOService.callbackDAO.addStudent(new Student(
				"Cecelia", "Carlson", sdf.parse("1986-03-12")));
		Integer studentID2 = DAOService.callbackDAO.addStudent(new Student(
				"Carole", "Bush", sdf.parse("1983-07-03")));
		Integer studentID3 = DAOService.callbackDAO.addStudent(new Student(
				"Josefina", "Cummings", sdf.parse("1986-11-07")));
		// list students and assert
		List<Student> students = DAOService.callbackDAO.listStudents();
		assertNotNull(students);
		assertEquals(3, students.size());
		// delete students and assert
		for (Student student : students) {
			System.out.println(student);
			DAOService.callbackDAO.deleteStudent(student.getId());
		}
		students = DAOService.callbackDAO.listStudents();
		assertNotNull(students);
		assertEquals(0, students.size());
	}
}