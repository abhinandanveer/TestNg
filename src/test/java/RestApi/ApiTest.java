package RestApi;



import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
 
public class ApiTest
{
 
	@Test
	
	public void getUserTest()
	{
			given()
			.when().get("https://dummyjson.com/products/2")
			.then()
			.statusCode(200)
			.body("id", equalTo(2));
		
	}
	
}
 
 
