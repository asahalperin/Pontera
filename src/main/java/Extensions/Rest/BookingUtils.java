package Extensions.Rest;

import Utilities.CommonOps;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookingUtils extends CommonOps {

    public static BookingData createRandomBookingData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String checkin = dateFormat.format(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)); // Next week
        String checkout = dateFormat.format(new Date(System.currentTimeMillis() + 9 * 24 * 60 * 60 * 1000)); // 2 nights after check-in
        BookingDates bookingDates = new BookingDates(checkin, checkout);
        test.log(Status.INFO, "Creating new booking");
        return new BookingData(users().firstName(), users().lastName(), 150, true, bookingDates, "Breakfast");
    }

    public static int createBookingAndGetId(BookingData bookingData) {
        Response response = RestUtils.createBooking(bookingData);
        int bookingId = response.jsonPath().getInt("bookingid");
        test.log(Status.PASS, "Booking created with ID: " + bookingId);
        return bookingId;
    }

    public static boolean isBookingPresent(int bookingId) {
        List<Integer> allBookingIds = RestUtils.getAllBookings().jsonPath().getList("bookingid");
        return allBookingIds.contains(bookingId);
    }
}


