package learn.avinash.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestDemo {
    @BeforeClass
    public void steup(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/store";

    }

    @Test
    public void TestPost(){
        given()
                .when()
                .post("/order")
                .then()
                .statusCode(201)
                .and()
                .contentType(ContentType.JSON);
    }
}
