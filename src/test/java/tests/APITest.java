package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class APITest {
    public static RequestSpecification requestSpecification(String quantity) {
        return new RequestSpecBuilder().setBaseUri("https://fakerapi.it/api/v1/companies")
                .addQueryParam("_quantity", quantity)
                .build();
    }

    @Test
    public void testTwentyData() {
        given().spec(requestSpecification("20"))
                .when().get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("total", is(20))
                .body("data", hasSize(20)).log().all();
    }

    @Test
    public void testFiveData() {
        given().spec(requestSpecification("5"))
                .when().get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("total", is(5))
                .body("data", hasSize(5)).log().all();
    }

    @Test
    public void testOneData() {
        given().spec(requestSpecification("1"))
                .when().get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("total", is(1))
                .body("data", hasSize(1)).log().all();
    }
}
