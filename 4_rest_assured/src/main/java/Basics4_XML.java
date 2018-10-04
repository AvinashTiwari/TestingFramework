import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics4_XML {

    @Test()
    public void postData() throws IOException {
        String xmldata = GenerateStringFromResource("K:\\TestingFrameWork\\4_rest_assured\\src\\files\\Podata.xml");
        RestAssured.baseURI="http://216.10.245.166";
      Response res =   given()
                .queryParam("key", "qaclick123")
               .body(xmldata).when()
        .post("/maps/api/place/add/xml")
        .then()
        .assertThat()
        .statusCode(200)
        .and()
        .contentType(ContentType.XML).extract().response()

        ;
    }

    public static String GenerateStringFromResource(String path) throws IOException {
        return (new String(Files.readAllBytes(Paths.get(path))));
    }
}
