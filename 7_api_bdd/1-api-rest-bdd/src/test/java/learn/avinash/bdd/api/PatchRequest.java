package learn.avinash.bdd.api;

import io.restassured.http.ContentType;
import learn.avinash.bdd.model.Address;
import learn.avinash.bdd.model.FirstUser;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchRequest {

    @Test
    public void pacthJsonPlaceHolder(){

        FirstUser firstUser = new FirstUser();

        firstUser.setFirstName("Avinash");
        firstUser.setLastName("Tiwari");
        Address address = new Address();
        address.setEmail("qwe123kids@gmail.com");
        address.setPhone(99678676);
        address.setStreetAddress("11 80124 CO usa");
        firstUser.setAddress(address);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(firstUser)
                .patch("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

}
