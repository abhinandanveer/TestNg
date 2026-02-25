package RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Post {

    @Test
    public void create() {

        String body = "{ \"title\":\"Phone\",\"price\":500 }";

        given()
            .header("Content-Type","application/json")
            .body(body)
        .when()
            .post("https://dummyjson.com/products/add")
        .then()
            .statusCode(201)
            .log().all();
    }
}