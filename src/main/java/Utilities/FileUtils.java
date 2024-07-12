package Utilities;

import Extensions.Rest.BookingData;
import com.aventstack.extentreports.ExtentTest;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    private static final String JSON_FILE_PATH = "bookingData.json";

    public static void writeBookingDataToFile(BookingData bookingData, ExtentTest test) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(bookingData);

        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            writer.write(jsonString);
            test.info("Booking data written to file: " + JSON_FILE_PATH);
        } catch (IOException e) {
            test.fail("Failed to write booking data to file: " + e.getMessage());
        }
    }

    public static void attachJsonToReport(ExtentTest test) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
            test.info("Booking data JSON: <pre>" + jsonContent + "</pre>");
        } catch (IOException e) {
            test.fail("Failed to read booking data JSON file: " + e.getMessage());
        }
    }
}