package com.studentapp.junit.studentinfo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtil;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTest extends TestBase {
	
	static String firstName =TestUtil.getRandomValue()+ " -Avinash";
	static String lastName =TestUtil.getRandomValue()+ "  -Tiwari";
	static String programme = "ComputerScience";
	static String email =  TestUtil.getRandomValue()+"abc@12376778.com";
	static int studentId ;
	
	@Steps
	StudentSerenitySteps studentSerenitySteps;
	
	@Title("This test Will Create New Student")
	@Test
	public void test001(){
		

		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		
		studentSerenitySteps.createStudent(firstName, lastName, email, programme, courses)
		.statusCode(201);
		
	}
	
	
	@Title("Student was added to the  applciation")
	@Test
	public void test002(){
	HashMap<String, Object> value=	SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("findAll{it.firstName=='"+firstName+"'}.get(0)");
	
	System.out.println("The value is " + value);
	studentId = (int)value.get("id");
	
	assertThat(value, hasValue(firstName));
	}

	@Title("Update the User Information and Verify updated information")
	@Test
	public void test003(){
		
		ArrayList<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("C++");
		firstName = firstName + "_updated";
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(course);
		
		SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.put("/" + studentId)
		.then()
		.log()
		.all();
		
		HashMap<String, Object> value=	SerenityRest.rest()
				.given()
				.when()
				.get("/list")
				.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.path("findAll{it.firstName=='"+firstName+"'}.get(0)");
			
			System.out.println("The value is " + value);
			studentId = (int)value.get("id");
			
			assertThat(value, hasValue(firstName));
		
	}
	
	@Title("Delete the Student and veify if student is deleted")
	@Test
	public void test004(){
		SerenityRest.rest().given()
		.when()
		.delete("/" + studentId)
		.then()
		.log()
		.all();
		
		
		SerenityRest.rest()
		.given()
		.when()
		.get("/"+studentId)
		.then()
		.log()
		.all()
		.statusCode(404);
	
	}
}
