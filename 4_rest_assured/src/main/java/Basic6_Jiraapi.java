import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Basic6_Jiraapi {
    Properties prop = new Properties();

    @BeforeTest()
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream(".\\src\\files\\env.properties");
        prop.load(fis);
    }

    @Test
    public void JiraApi_Post(){
        RestAssured.baseURI=        "http://localhost:8080";
        Response res = given().header("Content-Type", "application/json")
                .header("Cookie", "JSESSIONID="+ReuseableMethod.getSessionKey())
                .body("{\"fields\" : { \"project\" : {  \"key\" : \"RES\" }, \"summary\" : \"For comment Jira Posy Resr Test\", \"description\" :  \"Creating  first Bug By test class\" , \"issuetype\" : { \"name\" : \"Bug\" }}}")
                .when()
                .post("/rest/api/2/issue")
                .then()
                .statusCode(201)
                .extract()
                .response();
        JsonPath js =  ReuseableMethod.rawToJson(res);
        String session =  js.get("id");
        System.out.println(session);


    }

}
