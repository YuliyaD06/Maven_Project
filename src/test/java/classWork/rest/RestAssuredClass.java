package classWork.rest;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;


///<<<---REST ASSURED FOR WEB SERVICES--->>>///

public class RestAssuredClass {

    private static final String JSON = "src/test/resources/json/users.json";

    public static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("http://178.124.206.46:8001/app/ws/")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static User getUser(String name) throws FileNotFoundException {

        Gson gson = new Gson();
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        return data.data.stream().filter(user -> user.username.equals(name)).findAny().get();

    }

    @Test
    public void testMethod() throws FileNotFoundException {
        String name = "a";

        RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION)
                .body(new Search(name, false))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).data.get(0).equals(RestAssuredClass.getUser("a"));

    }
}
