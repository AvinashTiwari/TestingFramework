package com.studentapp.cucumber.serenity;

import java.util.ArrayList;
import java.util.List;

import com.studentapp.model.StudentClass;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {

	@Step
	public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme,
			List<String> courses) {

		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(courses);

		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(student).post().then();
	}

}
