package tests;

import classWork.rest.Data;
import classWork.rest.Search;
import classWork.rest.User;
import objects.RestSearchObject;
import org.junit.Assert;
import org.junit.Test;
import steps.RestSearchSteps;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class RestSearchUsers {

    RestSearchSteps searchStep = new RestSearchSteps();

    @Test
    public void searchByFullNameTest() throws FileNotFoundException {
        String name = "berta";
        User data = given()
                .when()
                .spec(RestSearchObject.REQUEST_SPECIFICATION).body(new Search(name,true))
                .when()
                .post()
                .then()
                .extract()
                .as(Data.class).data.stream().filter(user -> user.username.contains(name)).findAny().get();
        Assert.assertEquals(data, searchStep.getUserFull(name));
    }

    @Test
    public void searchByPartialNameTest() throws FileNotFoundException {
        String name = "b";
        User data = given()
                .when()
                .spec(RestSearchObject.REQUEST_SPECIFICATION).body(new Search(name,false))
                .when()
                .post()
                .then()
                .extract()
                .as(Data.class).data.stream().filter(user -> user.username.contains(name)).findAny().get();
        //.as(Data.class).data.stream().filter(user -> user.username.contains(name)).findAny().get();
        Assert.assertEquals(data, searchStep.getUserPartial(name));
    }

    @Test
    public void searchAllUsersTest(){
        String name = "";
        User data = given()
                .when()
                .spec(RestSearchObject.REQUEST_SPECIFICATION).body(new Search(name,false))
                .when()
                .post()
                .then()
                .extract()
                .as(Data.class).data.stream().filter(user -> user.username.contains(name)).findAny().get();
        //allMAtch

        //Assert.assertEquals();
    }
}
