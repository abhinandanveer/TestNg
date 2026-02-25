package RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutProduct {

    @Test
    public void update() {

        String body = "{ \"title\":\"Updated Phone\" }";

        given()
            .header("Content-Type","application/json")
            .body(body)
        .when()
            .put("https://dummyjson.com/products/1")
        .then()
            .statusCode(200)
            .body("title", equalTo("Updated Phone"))
            .log().all();
    }
}