import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Basic7_Jiraapi_Put {
    Properties prop = new Properties();

    @BeforeTest()
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream(".\\src\\files\\env.properties");
        prop.load(fis);
    }

    @Test
    public void JiraApi_Add_comment_Post(){
        //
        RestAssured.baseURI=        "http://localhost:8080";
        Response res = given().header("Content-Type", "application/json")
                .header("Cookie", "JSESSIONID="+ReuseableMethod.getSessionKey())
                .body("{\"body\":\"Insert comment updated again\",\"visibility\" :{\"type\" :\"role\",\"value\":\"Administrators\" }}")
                .when()
                .post("/rest/api/2/issue/10300/comment")
                .then()
                .statusCode(201)
                .extract()
                .response();
      //  JsonPath js =  ReuseableMethod.rawToJson(res);
      //  String session =  js.get("id");
        //System.out.println(session);


    }

    @Test
    public void JiraApi_Add_comment_Put(){
        //
        RestAssured.baseURI=        "http://localhost:8080";
        Response res = given().header("Content-Type", "application/json")
                .header("Cookie", "JSESSIONID="+ReuseableMethod.getSessionKey())
                .body("{\"body\":\"Updating comment updated again\",\"visibility\" :{\"type\" :\"role\",\"value\":\"Administrators\" }}")
                .when()
                .post("/rest/api/2/issue/10300/comment/10001")
                .then()
                .statusCode(200)
                .extract()
                .response();
        //  JsonPath js =  ReuseableMethod.rawToJson(res);
        //  String session =  js.get("id");
        //System.out.println(session);


    }

}
