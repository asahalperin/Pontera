package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.fail;

public class Click extends Base {
    //Selenium click operation with error handling
    public static void go(WebElement elem, String elemName) {
        try {
            Wait.forElementIsClickable(elem);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
            elem.click();
            test.log(Status.PASS, elemName + " Clicked successfully");
        } catch (Exception e) {
            test.log(Status.FAIL,e + ". Failed to click on: " + elemName + ". Screenshot: ", screenShot());
            fail(e.getMessage() + "Failed to click: " + elemName);
        }
    }
}
