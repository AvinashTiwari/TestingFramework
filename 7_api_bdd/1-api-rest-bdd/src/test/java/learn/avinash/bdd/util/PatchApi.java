package learn.avinash.bdd.util;


import io.restassured.http.ContentType;
import learn.avinash.bdd.model.FirstUser;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by alexeykozlov on 1/28/19.
 */
public class PatchApi {

    @Test
    public void patchJsonPlaceholder() {

        FirstUser user = new FirstUser();
        user.setFirstName("Sherlock");
        user.setLastName("Holmes");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .patch("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .log()
                .all();

    }
}
