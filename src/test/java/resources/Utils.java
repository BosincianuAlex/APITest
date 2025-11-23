package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.Stats;
import pojo.Stats.Stat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Utils {

    public RequestSpecification requestSpec(String path, String resource) throws IOException {

        return new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")+path+resource).setContentType(ContentType.JSON).build();
    }


    public List<Stats> payload(){
        Stats.Stat obj2;
        obj2 = new Stat();
        obj2.setName("alcohol resistance");
        obj2.setUrl("url");

        Stats obj1 = new Stats();
        obj1.setBaseStat("9000");
        obj1.setStat(obj2);

        List<Stats> a = new ArrayList<>();
        a.add(obj1);
        return a;
    }


    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
