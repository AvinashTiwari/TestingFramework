package com.studentapp.junit.studentinfo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtil;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
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
	
	@Title("This test Will Create New Student")
	@Test
	public void test001(){
		
		ArrayList<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("C++");
		
		
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
		.post()
		.then()
		.log()
		.all()
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
	
	assertThat(value, hasValue(firstName));
	}

}
