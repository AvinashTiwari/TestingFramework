package learn.avinash.restassured.framework.status;

import static io.restassured.RestAssured.given;

import learn.avinash.restassured.framework.common.RestUtilities;
import learn.avinash.restassured.framework.constant.EndPoints;
import learn.avinash.restassured.framework.constant.Path;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TwitterWorkflowTest {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    String tweetId = "";

    @BeforeClass
    public void setup() {
        reqSpec = RestUtilities.getRequestSpecification();
        reqSpec.basePath(Path.STATUSES);

        resSpec = RestUtilities.getResponseSpecification();
    }

    @Test
    public void postTweet() {
        Response response =
                given()
                        .spec(RestUtilities.createQueryParam(reqSpec, "status", "My First Tweet"))
                        .when()
                        .post(EndPoints.STATUSES_TWEET_POST)
                        .then()
                        .spec(resSpec)
                        .extract()
                        .response();
        JsonPath jsPath = RestUtilities.getJsonPath(response);
        tweetId = jsPath.get("id_str");
        System.out.println("The response.path: " + tweetId);
    }

    @Test(dependsOnMethods = {"postTweet"})
    public void readTweet() {
        RestUtilities.setEndPoint(EndPoints.STATUSES_TWEET_READ_SINGLE);
        Response res = RestUtilities.getResponse(
                RestUtilities.createQueryParam(reqSpec, "id", tweetId), "get");
        String text = res.path("text");
        System.out.println("The tweet text is: " + text);
    }

    @Test(dependsOnMethods = {"readTweet"})
    public void deleteTweet() {
        given()
                .spec(RestUtilities.createPathParam(reqSpec, "id", tweetId))
                .when()
                .post(EndPoints.STATUSES_TWEET_DESTROY)
                .then()
                .spec(resSpec);
    }
}

