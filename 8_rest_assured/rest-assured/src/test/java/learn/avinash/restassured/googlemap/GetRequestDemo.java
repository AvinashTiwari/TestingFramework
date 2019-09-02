package learn.avinash.restassured.googlemap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetRequestDemo {

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
                .param("units","imperial")
                .param("origins", "Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key", apikey)
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
                .param("key", apikey)
                .when()
                .get("/distancematrix/json");

        System.out.println(res.body().asString());


    }
}
