package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination {

    @Given("^User is on net banking Landing Page$")
    public void user_is_on_net_banking_landing_page() throws Throwable {
    	System.out.println("Code to User is on net banking Landing Page");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
    	System.out.println("Code to User login into application with username and password");

    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
    	System.out.println("Code to Home page is populated");

    }

    @And("^Cards are Displayed$")
    public void cards_are_displayed() throws Throwable {
    	System.out.println("Code to Cards are Displayed");

    }

}