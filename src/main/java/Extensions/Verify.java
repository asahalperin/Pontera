package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Verify extends Base {

    //TestNG assertion with error handling and write to log
    public static void elementExists(WebElement elem, String elemName) {
        try {
            Wait.forElementIsClickable(elem);
            assertTrue(elem.isDisplayed());
            test.log(Status.PASS, "Step passed - Element " + elemName + " is displayed.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Expected element is not displayed. See screenshot: ", screenShot());
            fail(e + "Step failed - Error while Asserting element: " + elemName + " display");
        } catch (Exception e) {
            fail(e + "Step failed - Assert Element" + elemName + " Exists");
        }
    }

    public static void elementTextEqual(WebElement elem, String expectedText) {
        String actualText = null;
        try {
            Wait.forElementIsClickable(elem);
            actualText = elem.getText();
            assertTrue(actualText.equals(expectedText));
            test.log(Status.PASS, "Step passed - Text from element is: '" + actualText + "', as expected");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Step failed - Text from element is: '" + actualText + "', and not as expected: '" + expectedText + "'", screenShot());
            fail(e + "Step failed - Text is not equal");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }

    public static void generalBoolean(boolean bool, String text) {
        try {
            assertTrue(bool);
            test.log(Status.PASS, "Step passed -" + text + " - True");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Step failed -" + text + " - False", screenShot());
            fail(e + "Step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }

    public static void textEqual(String actualText, String expectedText, String message) {
        try {
            assertTrue(actualText.equals(expectedText));
            test.log(Status.PASS, message + " passed - Result is: '" + actualText + "', as expected");
        } catch (AssertionError e) {
            test.log(Status.FAIL, message + " failed - Result is: '" + actualText + "', - not as expected: '" + expectedText + "'");
            fail(e + "Step failed - Text is not equal");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }
}
