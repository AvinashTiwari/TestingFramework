package learn.avinash.restassured.requestlogging;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class ResponseLoggingExample {
    String consumerKey =  "";
    String consumerSecret = "";
    String accessToken = "";
    String accessSecret = "";
    String tweetId = "";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.twitter.com";
        RestAssured.basePath = "/1.1/statuses";
        consumerKey =  System.getenv("TWITTER_CONSUMER_API_KEY");
        consumerSecret = System.getenv("TWITTER_CONSUMER_API_SECRET_KEY");
        accessToken = System.getenv("TWITTER_ACCESS_TOKEN");
        accessSecret = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    }

    @Test
    public void testMethod() {
        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                .queryParam("status", "My First Tweet 11")
                .when()
                .post("/update.json")
                .then()
                .log()
                //.headers()
                //.body()
                //.all()
                .ifError()
                .statusCode(200);
    }
}
