package stepDefinitions;

import io.cucumber.java.en.*;
import pojo.Pokemon;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils {

    Pokemon pokemon;

    @Given("return object with id {string}")
    public void return_object_with_id(String id) throws IOException {

        pokemon = given().spec(requestSpec(id)).when().get().then().extract().body().as(Pokemon.class);

    }

    @Then("expect object name to be {string}")
    public void expect_object_name_to_be(String name) {

        assertEquals(pokemon.getName(), name);
    }
}
