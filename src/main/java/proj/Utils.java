package proj;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Utils  {

    @Test(dataProvider = "testData")
    static void func(Object a){
        System.out.println(a);

    }

    @DataProvider(name="testData")
    static Object[] funcData() throws IOException {

        String apiData = new String(Files.readAllBytes(Paths.get("src/apiData.json")));
        List<HashMap> json = new JsonPath(apiData).getList("");

        Object[] list= json.toArray();
        //json.forEach(item -> System.out.println(item.get("data")));

        return list;
    }
}


