package learn.avinash.restassured.framework.constant;

public class Auth {

    public static final String  CONSUMER_KEY  =  System.getenv("TWITTER_CONSUMER_API_KEY");
    public static final String CONSUMER_SECRET  = System.getenv("TWITTER_CONSUMER_API_SECRET_KEY");
    public static final String ACCESS_TOKEN  = System.getenv("TWITTER_ACCESS_TOKEN");
    public static final String ACCESS_SECRET  = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
}
