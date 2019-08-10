package learn.avinash.bdd.util;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetApi {
    @Test
    public void makeSureThatGoogleIsUp() {
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1");

        System.out.println(response.body().asString());


    }

    @Test
    public void statusCode(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .statusCode(200);
    }
}