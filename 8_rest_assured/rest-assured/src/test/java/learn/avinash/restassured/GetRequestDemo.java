package learn.avinash.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetRequestDemo {


    @BeforeClass
    public void steup(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";

    }

    @Test
    public void statusCodeVerification(){
        given()
                .param("units","imperial")
                .param("origins", "Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key", "")
                .when()
                        .get("/distancematrix/json")
                        .then()
                        .statusCode(200);

    }

    @Test
    public void getResponseBody(){
        Response res =
        given()
                .param("units","imperial")
                .param("origins", "Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key", "")
                .when()
                .get("/distancematrix/json");

        System.out.println(res.body().asString());


    }
}
