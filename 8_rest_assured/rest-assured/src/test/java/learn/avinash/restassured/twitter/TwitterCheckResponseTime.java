package learn.avinash.restassured.twitter;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class TwitterCheckResponseTime {
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
//		long responseTime =
//		given()
//			.auth()
//			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
//			.queryParam("user_id", "apiautomation")
//		.when()
//			.get("/user_timeline.json")
//			//.time();
//			.timeIn(TimeUnit.SECONDS);
//		System.out.println("Response Time: " + responseTime);

        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                .queryParam("user_id", "apiautomation")
                .when()
                .get("/user_timeline.json")
                .then()
                .statusCode(200)
                .time(lessThan(1L), TimeUnit.SECONDS)
                .log().body()
                .body("user.name", hasItem("RestAPI Automation"))
                .body("user.screen_name", hasItem("apiautomation"))
                .body("entities.hashtags[0].text", hasItem("multiple"))
                .body("entities.hashtags[0].size()", equalTo(2));
    }
}
