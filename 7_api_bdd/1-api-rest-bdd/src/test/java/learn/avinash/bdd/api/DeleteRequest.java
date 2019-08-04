package learn.avinash.bdd.api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @Test
    public void getJsonPlaceHolder(){


        given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .statusCode(200);

    }
}
