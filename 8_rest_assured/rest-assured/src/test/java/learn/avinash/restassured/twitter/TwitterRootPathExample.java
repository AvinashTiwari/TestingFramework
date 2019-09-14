package learn.avinash.restassured.twitter;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class TwitterRootPathExample {
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
    public void readTweets() {
        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                .queryParam("user_id", "apiautomation")
                .when()
                .get("/user_timeline.json")
                .then()
                .statusCode(200)
                .log().body()
                //.rootPath("user")
//			.body("user.name", hasItem("RestAPI Automation"))
//			.body("user.screen_name", hasItem("apiautomation"))
                //.rootPath("entities.hashtags[0]")
                .body("text", hasItem("multiple"))
                .body("size()", equalTo(2));
    }
}
