package learn.avinash.restassured.framework.status;

import static io.restassured.RestAssured.given;

import learn.avinash.restassured.framework.common.RestUtilities;
import learn.avinash.restassured.framework.constant.EndPoints;
import learn.avinash.restassured.framework.constant.Path;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;


public class UserTimelineTest {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;

    @BeforeClass
    public void setup() {
        reqSpec = RestUtilities.getRequestSpecification();
        reqSpec.queryParam("user_id", "qwe123kids");
        reqSpec.basePath(Path.STATUSES);

        resSpec = RestUtilities.getResponseSpecification();
    }

    @Test
    public void readTweets1() {
        given()
                .spec(RestUtilities.createQueryParam(reqSpec, "count", "1"))
                .when()
                .get(EndPoints.STATUSES_USER_TIMELINE)
                .then()
                .log().all()
                .spec(resSpec)
                .body("user.screen_name", hasItem("qwe123kids"));
    }

    @Test
    public void readTweets2() {
        RestUtilities.setEndPoint(EndPoints.STATUSES_USER_TIMELINE);
        Response res = RestUtilities.getResponse(
                RestUtilities.createQueryParam(reqSpec, "count", "2"), "get");
        ArrayList<String> screenNameList = res.path("user.screen_name");
        System.out.println("Read Tweets 2 Method");
        Assert.assertTrue(screenNameList.contains("qwe123kids"));
    }
}