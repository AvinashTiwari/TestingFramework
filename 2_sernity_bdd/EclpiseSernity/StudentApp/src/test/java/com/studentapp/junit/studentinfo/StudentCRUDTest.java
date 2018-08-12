package com.studentapp.junit.studentinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtil;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
@RunWith(SerenityRunner.class)
public class StudentCRUDTest extends TestBase {
	
	static String firstName =TestUtil.getRandomValue()+ " -Avinash";
	static String lastName =TestUtil.getRandomValue()+ "  -Tiwari";
	static String programme = "ComputerScience";
	static String email =  TestUtil.getRandomValue()+"abc@12376778.com";
	
	@Title("This test Will Create New Student")
	@Test
	public void CreateStudent(){
		
		ArrayList<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("C++");
		
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(course);
		
		SerenityRest.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
	}

}
