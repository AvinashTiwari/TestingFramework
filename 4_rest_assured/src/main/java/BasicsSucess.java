import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class BasicsSucess {

    public static void main(String[] args) {
        RestAssured.baseURI="https://maps.googleapis.com";
        given().param("location", "-33.8670522,151.1957362")
                .param("radius","1500")
                .param("type", "restaurant")
                .param("keyword", "cruise")
                .param("key","AIzaSyBNFr6lZh5tpxcokwHIHCwbd5zM6iUmqR8")
                .when()
                .get("/maps/api/place/nearbysearch/json")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
