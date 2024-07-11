package Tests;

import Extensions.Rest.BookingData;
import Extensions.Rest.BookingUtils;
import Utilities.CommonOps;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookingTest extends CommonOps {

    @Test(testName = "Create new booking - Valid")
    public void createAndValidateBooking() {
        BookingData bookingData = BookingUtils.createRandomBookingData();
        int bookingId = BookingUtils.createBookingAndGetId(bookingData);
        test.log(Status.INFO, "Validating new booking exists");
        Assert.assertTrue(BookingUtils.isBookingPresent(bookingId), "New booking is not in the list of all bookings");
        test.log(Status.PASS, "New booking is validated in the list of all bookings");
    }
}
