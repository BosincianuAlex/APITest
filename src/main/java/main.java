import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Pokemon;
import pojo.Stats;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public static void main() throws IOException {


    RestAssured.baseURI="https://pokeapi.co/api/v2/pokemon/6/";

    Pokemon pokemon = given().when().get().then().extract().body().as(Pokemon.class);

    System.out.print( STR."\{pokemon.getName()}'s ablities: \n" );
    pokemon.getMoves().forEach(i -> System.out.println(i.getMove().getName()));

    System.out.print( STR."\{pokemon.getName()}'s base stats: \n" );
    pokemon.getStats().forEach(i-> System.out.println(STR."\{i.getStat().getName()} \{i.getBaseStat()}"));

    RestAssured.baseURI= "https://gen-endpoint.com/api/echo";

    String response = given().body(pokemon).when().post().then().extract().response().asString();

    List<Map<String, Object>> object = new JsonPath(response).getList("receivedBody.stats");
    System.out.println(object.get(0));
    object.forEach(i-> System.out.println(i.get("base_stat")));



}
