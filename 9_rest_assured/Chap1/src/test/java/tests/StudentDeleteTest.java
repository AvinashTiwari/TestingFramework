package tests;


import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import learn.avinash.restassured.base.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class StudentDeleteTest extends TestBase {
	
	
	/**
	 * Test for Deleting student information
	 */
	@Test
	public void deleteStudent(){
		//Put the student ID here
		String studentId="59";
		
		given()
		.when()
		.delete("/"+studentId)
		.then()
		.statusCode(204);
	}

}
