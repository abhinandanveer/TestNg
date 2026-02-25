package RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteProduct {

    @Test
    public void deleteProduct() {

        delete("https://dummyjson.com/products/1")
        .then()
            .statusCode(200)
            .log().all();
    }
}