package learn.avinash.bdd.api;

/*
*
* {
  "name": "Avinash",
  "username": "Tiwari",

  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
	"email": "Sincere@april.biz"
  }
 }*/

import io.restassured.http.ContentType;
import learn.avinash.bdd.model.Address;
import learn.avinash.bdd.model.FirstUser;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {

    @Test()
    public void jsonPlaceHolder()
    {
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
                    .post("https://jsonplaceholder.typicode.com/users")
                    .then()
                    .statusCode(201)
                    .log()
                    .all();


    }

}
