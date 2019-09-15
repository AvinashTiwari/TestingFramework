package learn.avinash.restassured.twitter;

import static io.restassured.RestAssured.given;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class RequestSpecificationDemo {
    String consumerKey =  "";
    String consumerSecret = "";
    String accessToken = "";
    String accessSecret = "";
    String tweetId = "";
    RequestSpecBuilder requestBuilder;
    static RequestSpecification requestSpec;
    @BeforeClass
    public void setup() {
        AuthenticationScheme authScheme =
                RestAssured.oauth(consumerKey, consumerSecret, accessToken, accessSecret);
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://api.twitter.com");
        requestBuilder.setBasePath("/1.1/statuses");
        requestBuilder.addQueryParam("user_id", "apiautomation");
        requestBuilder.setAuth(authScheme);
        requestSpec = requestBuilder.build();

        consumerKey =  System.getenv("TWITTER_CONSUMER_API_KEY");
        consumerSecret = System.getenv("TWITTER_CONSUMER_API_SECRET_KEY");
        accessToken = System.getenv("TWITTER_ACCESS_TOKEN");
        accessSecret = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    }

    @Test
    public void readTweets() {
        given()
                .spec(requestSpec)
//			.auth()
//			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
//			.queryParam("user_id", "apiautomation")
                .when()
                .get("/user_timeline.json")
                .then()
                .statusCode(200);
    }
}
