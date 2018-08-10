package com.studentapp.junit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class FirstSerenityTest {
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI ="http://localhost:8081/student";
 	}
	
	@Test
	public void getAllStudent(){
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
