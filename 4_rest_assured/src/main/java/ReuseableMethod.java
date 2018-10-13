import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReuseableMethod {

    public static XmlPath rawToXML(Response r)
    {


        String respon=r.asString();
        XmlPath x=new XmlPath(respon);
        return x;

    }

    public static JsonPath rawToJson(Response r)
    {
        String respon=r.asString();
        JsonPath x=new JsonPath(respon);
        return x;
    }

    public  static String getSessionKey(){
        RestAssured.baseURI=        "http://localhost:8080";
        Response res = given().header("Content-Type", "application/json")
                .body("{ \"username\" : \"avit4143\", \"password\" : \"9967541245\" }")
                .when()
                .post("/rest/auth/1/session")
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath js =  ReuseableMethod.rawToJson(res);
        String session =  js.get("session.value");

        return session;

    }
}
