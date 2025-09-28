import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.*;
import io.restassured.RestAssured;
import org.w3c.dom.ls.LSOutput;
import proj.Item;
import proj.pojo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public static void main() throws IOException {


    String apiData = new String(Files.readAllBytes(Paths.get("src/apiData.json")));

    ObjectMapper mapper = new ObjectMapper();
    List<pojo> players = mapper.readValue(apiData, new TypeReference<>() {
    });

    pojo playerOne= players.get(0);

    System.out.println(String.format("%s draws his %s and %s's his opponent",
            playerOne.getName(),playerOne.getInventory().get(0).getName(), playerOne.getSkills().get(0).getName()));

    List<List<Item>> items = new ArrayList<>();

    players.forEach(i->
        {if("Warrior".equals(i.getCharClass()) && "Iron Sword".equals(i.getInventory().get(0).getName()))
        {
            System.out.println(STR."\{i.getName()} has \{i.getInventory().get(0).getName()}, he needs an upgrade to steel sword");
            items.add(i.getInventory());
        }}

    );

    System.out.println(items.get(0).get(1).getItemId());

}
