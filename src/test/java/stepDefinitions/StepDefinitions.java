package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import pojo.Pokemon;
import pojo.Stats;
import resources.APIPaths;
import resources.Utils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils {

    Pokemon pokemonObj = new Pokemon();

    @Given("{string} endpoint with id {string}")
    public void return_object_with_id(String pokemon, String resource) throws IOException {

        pokemonObj = given().spec(requestSpec(APIPaths.valueOf(pokemon).getPath(), resource))
                .when().get().then().extract().body().as(Pokemon.class);

    }

    @Then("expect response object name to be {string}")
    public void expect_object_name_to_be(String name) {
        System.out.println(pokemonObj.getName());
        assertEquals(pokemonObj.getName(), name);
    }

    @Given("step one")
    public void step_one() {

        pokemonObj.setName("abra");
        pokemonObj.setStats("900","attack","urlTxt");

        String response = given().baseUri("https://gen-endpoint.com/api/echo").
                body(pokemonObj).when()
                .post().then().extract().response().asString();
        System.out.println(response);
        List<Map<String, Object>> object = new JsonPath(response).getList("receivedBody.stats");
        String objName = new JsonPath(response).getString("receivedBody.name");

        System.out.println(objName);
        System.out.println(object.get(0).get("base_stat"));



    }

    @Then("step two")
    public void step_two() {
        System.out.println();
    }
}
