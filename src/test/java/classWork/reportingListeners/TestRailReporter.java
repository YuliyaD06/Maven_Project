package classWork.reportingListeners;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestRailReporter {

    public static void main(String[] args) {

    }

    public static void reportResult(String runID, String caseID, Result result){

        System.out.println(
                RestAssured
                        .given()
                        .spec(getRSpec())
                        .body(new Gson().toJson(result))
                        .when()
                        .post(String.format("index.php?/api/v2/add_result_for_case/%s/%s", runID, caseID))
                        .then()
                        .extract().body().asString()
        );

    }

    private static RequestSpecification getRSpec(){

            PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
            authScheme.setUserName("fakemail@tech.co");
            authScheme.setPassword("Abc123");

            return new RequestSpecBuilder()
                    .setBaseUri("http://178.124.206.46")
                    .setPort(8000)
                    .setAccept(ContentType.JSON)
                    .setContentType(ContentType.JSON)
                    .setAuth(authScheme)
                    .log(LogDetail.ALL)
                    .build();

    }
}
