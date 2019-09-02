package learn.avinash.restassured.googlemap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidateResponse {
    String apikey = "";

    @BeforeClass
    public void steup(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";

        //
        apikey = System.getenv("GOOGLE_MAP_API_KEY");



    }

    @Test
    public void statusCodeVerification(){
        given()
                .param("units", "imperial")
                .param("origins", "Washington,DC")
                .param("destinations", "New+York+City,NY")
                .param("key", apikey)
                .when()
                .get("/distancematrix/json")
                .then()
                .statusCode(200)
                .and()
                .body("rows[0].elements[0].distance.text", equalTo("225 mi"))
                .contentType(ContentType.JSON);

    }
}
