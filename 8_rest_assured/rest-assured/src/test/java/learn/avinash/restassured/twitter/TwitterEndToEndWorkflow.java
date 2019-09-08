package learn.avinash.restassured.twitter;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TwitterEndToEndWorkflow {
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
    public void postTweet() {
        Response response =
                given()
                        .auth()
                        .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                        .queryParam("status", "My First Tweet")
                        .when()
                        .post("/update.json")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        tweetId = response.path("id_str");
        System.out.println("The response.path: " + tweetId);
    }

    @Test(dependsOnMethods={"postTweet"})
    public void readTweet() {
        Response response =
                given()
                        .auth()
                        .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                        .queryParam("id", tweetId)
                        .when()
                        .get("/show.json")
                        .then()
                        .extract()
                        .response();

        String text = response.path("text");
        System.out.println("The tweet text is: " + text);
    }

    @Test(dependsOnMethods={"readTweet"})
    public void deleteTweet() {
        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                .queryParam("id", tweetId)
                .when()
                .post("/destroy.json")
                .then()
                .statusCode(200);
    }
}
