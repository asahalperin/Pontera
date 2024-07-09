package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;

import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Verify extends Base {

    //TestNG assertion with error handling and write to log
    public static void elementExists(WebElement elem, String elemName, int millisSeconds) {
        try {
            Wait.ForElementIsClickable(elem, millisSeconds);
            assertTrue(elem.isDisplayed());
            test.log(Status.PASS, "Step passed - Element " + elemName + " is displayed.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Expected element is not displayed. See screenshot: ", screenShot());
            fail(e + "Step failed - Error while Asserting element: " + elemName + " display");
        } catch (Exception e) {
            fail(e + "Step failed - Assert Element" + elemName + " Exists");
        }
    }
}
