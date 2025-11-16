package stepDefinitions;

import io.cucumber.java.en.*;

public class StepDefinitions {


    @Given("user name is {string}")
    public void user_name_is(String string) {
        System.out.println(string);
    }

    @When("system generates greeting {int}")
    public void system_generates_greeting(int number) {
        System.out.println(number+22);
    }

    @Then("message should be")
    public void message_should_be() {
        System.out.println(1);
    }
}
