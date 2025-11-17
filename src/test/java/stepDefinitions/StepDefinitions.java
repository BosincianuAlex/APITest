package stepDefinitions;

import io.cucumber.java.en.*;
import pojo.Pokemon;
import resources.APIResources;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils {

    Pokemon pokemonObj;

    @Given("return {string} with id {string}")
    public void return_object_with_id(String pokemon, String id) throws IOException {

        pokemonObj = given().spec(requestSpec(APIResources.valueOf(pokemon).getPath(), id))
                .when().get().then().extract().body().as(Pokemon.class);

    }

    @Then("expect object name to be {string}")
    public void expect_object_name_to_be(String name) {
        System.out.println(pokemonObj.getName());
        assertEquals(pokemonObj.getName(), name);
    }
}
