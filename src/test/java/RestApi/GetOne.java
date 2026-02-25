package RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetOne {

    @Test
    public void getOne() {

        get("https://dummyjson.com/products/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .log().all();
    }
}