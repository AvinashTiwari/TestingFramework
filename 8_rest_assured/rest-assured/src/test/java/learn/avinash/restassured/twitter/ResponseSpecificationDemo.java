package learn.avinash.restassured.twitter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
public class ResponseSpecificationDemo {
    String consumerKey =  "";
    String consumerSecret = "";
    String accessToken = "";
    String accessSecret = "";
    String tweetId = "";
    ResponseSpecBuilder responseBuilder;
    static ResponseSpecification responseSpec;
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.twitter.com";
        RestAssured.basePath = "/1.1/statuses";
        responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectStatusCode(200);
        responseBuilder.expectBody("user.name", hasItem("RestAPI Automation"));
        responseSpec = responseBuilder.build();

        consumerKey =  System.getenv("TWITTER_CONSUMER_API_KEY");
        consumerSecret = System.getenv("TWITTER_CONSUMER_API_SECRET_KEY");
        accessToken = System.getenv("TWITTER_ACCESS_TOKEN");
        accessSecret = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    }

    @Test
    public void readTweets() {
        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                .queryParam("user_id", "apiautomation")
                .when()
                .get("/user_timeline.json")
                .then()
//		.statusCode(200)
//		.body("user.name", hasItem("RestAPI Automation"))
//		.body("user.screen_name", hasItem("apiautomation"));
                .spec(responseSpec)
                .body("user.screen_name", hasItem("apiautomation"));
    }
}
