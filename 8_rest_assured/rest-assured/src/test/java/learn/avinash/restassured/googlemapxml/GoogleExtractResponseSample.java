package learn.avinash.restassured.googlemapxml;

import static io.restassured.RestAssured.given;

import io.restassured.path.xml.XmlPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GoogleExtractResponseSample {
    String apikey = "";

    @BeforeClass
    public void steup(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";

        //
        apikey = System.getenv("GOOGLE_MAP_API_KEY");

    }

    @Test
    public void extractResponse() {
        Response response = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New+York+City,NY")
                .queryParam("key", apikey)
                .when()
                .get("/distancematrix/xml")
                .then()
                .statusCode(200).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);

        String value = response.path("distancematrixresponse.row.element.duration.value");
        System.out.println("The duration value is: " + value);

        XmlPath xmlPath = new XmlPath(responseString);
        String text = xmlPath.get("distancematrixresponse.row.element.duration.text");
        System.out.println("The duration text using XMLPath is: " + text);
    }
}
