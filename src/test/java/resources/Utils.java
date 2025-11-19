package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public RequestSpecification requestSpec(String path, String resource) throws IOException {

        return new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")+path+resource).setContentType(ContentType.JSON).build();
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
