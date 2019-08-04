package learn.avinash.bdd;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest {

    @Test
    public void getJsonPlaceHolder(){
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1");

        System.out.println(response.body().asString());

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200);

    }

    @Test
    public void statusCode(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200);
    }
}
