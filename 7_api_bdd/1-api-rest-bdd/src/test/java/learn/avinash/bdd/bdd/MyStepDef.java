package learn.avinash.bdd.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


public class MyStepDef {

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(arg1);
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(arg1);
    }

}
