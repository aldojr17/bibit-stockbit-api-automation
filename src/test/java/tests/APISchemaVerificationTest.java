package tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertNotNull;

public class APISchemaVerificationTest {

    @Test
    public void testAPISchema() {
        InputStream jsonSchemaVerify = getClass().getClassLoader().getResourceAsStream("jsonschema.json");

        Response response = given().baseUri("https://fakerapi.it/api/v1/companies")
                .when().get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.id", everyItem(notNullValue()))
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaVerify)).log().all()
                .extract().response();

        JsonPath responseBody = response.jsonPath();
        List<Map<String, Object>> dataList = responseBody.getList("data");
        for (Map<String, Object> data : dataList) {
            assertNotNull(data.get("id"), "ID is null for object: " + data);
        }
    }
}
