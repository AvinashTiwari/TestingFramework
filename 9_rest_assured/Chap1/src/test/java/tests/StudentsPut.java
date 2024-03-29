package tests;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import java.util.ArrayList;

import learn.avinash.restassured.base.TestBase;
import learn.avinash.restassured.model.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class StudentsPut extends TestBase {
	

	
	
	@Test
	public void updateStudent(){
		//Put the student ID here
		String studentId="50";
		
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		courses.add("C#");
		
		Student student = new Student();
		student.setFirstName("Mark");
		student.setLastName("Taylor");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/"+studentId)
		.then()
		.statusCode(200);
		
	
	}

}
