package RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetALl {

    @Test
    public void getAll() {

        get("https://dummyjson.com/products")
        .then()
            .statusCode(200)
            .log().all();
    }
}