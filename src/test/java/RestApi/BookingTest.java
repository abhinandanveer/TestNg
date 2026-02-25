package RestApi;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BookingTest {

    static String token;
    static int bookingId;

    // 1️⃣ Create Token
    @Test(priority = 1)
    public void createToken() {

        baseURI = "https://restful-booker.herokuapp.com";

        token = given()
                .header("Content-Type","application/json")
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
        .when()
                .post("/auth")
        .then()
                .statusCode(200)
                .extract().path("token");

        System.out.println("Token = " + token);
    }

    // 2️⃣ Create Booking (POST)
    @Test(priority = 2)
    public void createBooking() {

        String body = "{\n" +
                "  \"firstname\" : \"Abhi\",\n" +
                "  \"lastname\" : \"Tester\",\n" +
                "  \"totalprice\" : 1500,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2024-01-01\",\n" +
                "    \"checkout\" : \"2024-01-05\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        bookingId = given()
                .header("Content-Type","application/json")
                .body(body)
        .when()
                .post("/booking")
        .then()
                .statusCode(200)
                .extract().path("bookingid");

        System.out.println("Booking ID = " + bookingId);
    }

    // 3️⃣ Get Booking (GET)
    @Test(priority = 3)
    public void getBooking() {

        given()
        .when()
            .get("/booking/" + bookingId)
        .then()
            .statusCode(200)
            .body("firstname", equalTo("Abhi"))
            .log().all();
    }

    // 4️⃣ Update Booking (PUT)
    @Test(priority = 4)
    public void updateBooking() {

        String updatedBody = "{\n" +
                "  \"firstname\" : \"Updated\",\n" +
                "  \"lastname\" : \"User\",\n" +
                "  \"totalprice\" : 2000,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2024-02-01\",\n" +
                "    \"checkout\" : \"2024-02-05\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        given()
            .header("Content-Type","application/json")
            .header("Cookie","token=" + token)
            .body(updatedBody)
        .when()
            .put("/booking/" + bookingId)
        .then()
            .statusCode(200)
            .body("firstname", equalTo("Updated"))
            .log().all();
    }

    // 5️⃣ Delete Booking (DELETE)
    @Test(priority = 5)
    public void deleteBooking() {

        given()
            .header("Cookie","token=" + token)
        .when()
            .delete("/booking/" + bookingId)
        .then()
            .statusCode(201)
            .log().all();
    }
}