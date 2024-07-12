package Extensions.Rest;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static Utilities.CommonOps.users;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class RestUtils extends Base {

    private static final String BASE_URL = users().url();

    public static Response createBooking(BookingData bookingData) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bookingData)
                .post(BASE_URL + "/booking");
        String statusCode = String.valueOf(response.getStatusCode());
        try {
            assertTrue(statusCode.equals("200"));
            test.log(Status.PASS, "Create Booking successfully with status code " + statusCode);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Create Booking status code is " + statusCode + " but should be 200");
            fail(e + "step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
        return response;
    }

    public static Response getAllBookings() {
        Response response = RestAssured.get(BASE_URL + "/booking");
        String statusCode = String.valueOf(response.getStatusCode());
        try {
            assertTrue(statusCode.equals("200"));
            test.log(Status.PASS, "Get All Bookings successfully with status code " + statusCode);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Get All Bookings status code is " + statusCode + " but should be 200");
            fail("step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
        return response;
    }
}
