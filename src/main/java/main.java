import io.restassured.RestAssured;
import pojo.Pokemon;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public static void main() throws IOException {


    RestAssured.baseURI="https://pokeapi.co/api/v2/pokemon/6/";

    Pokemon pokemon = given().when().get().then().extract().body().as(Pokemon.class);

    //System.out.print( STR."\{pokemon.getName()}'s ablities: \n" );
    //pokemon.getMoves().forEach(i -> System.out.println(i.getMove().getName()));

    System.out.print( STR."\{pokemon.getName()}'s base stats: \n" );
    pokemon.getStats().forEach(i-> System.out.println( i.getStat().getName()+ " "+i.getBaseStat() ));


}
