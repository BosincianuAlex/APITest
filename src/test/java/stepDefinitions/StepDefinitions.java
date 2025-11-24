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
    String response;

    @When("User sends  a GET request at {string} endpoint with id {string}")
    public void return_object_with_id(String pokemon, String resource) throws IOException {

        pokemonObj = given().spec(requestSpec(APIPaths.valueOf(pokemon).getPath(), resource))
                .when().get().then().extract().body().as(Pokemon.class);

    }

    @Then("Expect response object name to be {string}")
    public void expect_object_name_to_be(String name) {

        assertEquals(pokemonObj.getName(), name);

    }

    @Given("Request body set to {string} {string} {string} {string}")
    public void set_requestBody(String name,  String baseStat,  String statName, String url) {

        pokemonObj.setName(name);
        pokemonObj.setStats(baseStat, statName, url);
    }

    @When("User sends a POST with request body")
    public void user_send_postRequest() {

            response = given().baseUri("https://gen-endpoint.com/api/echo").
                    body(pokemonObj).when()
                    .post().then().extract().response().asString();

    }

    @Then("Expect response object to match {string} {string} {string} {string}")
    public void check_response(String name,  String baseStat,  String statName, String url) {

        List<Map<String, Object>> stat = new JsonPath(response).getList("receivedBody.stats.stat");
        List<Map<String, Object>> stats = new JsonPath(response).getList("receivedBody.stats");
        String objName = new JsonPath(response).getString("receivedBody.name");

        assertEquals(stat.getFirst().get("url"),url);
        assertEquals(stat.getFirst().get("name"),statName);
        assertEquals(stats.getFirst().get("base_stat"), baseStat);
        assertEquals(objName, name);

    }
}
