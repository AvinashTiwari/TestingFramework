package learn.avinash.restassured.googlemap;

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
                .contentType("application/json")
                .body("{\"id\":1,\"petId\":2,\"quantity\":3,\"shipDate\":\"2019-08-27T23:51:25.064Z\",\"status\":\"placed\",\"complete\":false}")
                .when()
                .post("/order")
                .then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
    }
}
