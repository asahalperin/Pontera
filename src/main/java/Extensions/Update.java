package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;

import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.fail;

public class Update extends Base {

    //Selenium SendKeys operation with error handling
    public static void text(WebElement elem, String value, String elemName, int millisSeconds) {
        try
        {
            Wait.ForElementIsClickable(elem, millisSeconds);
            elem.sendKeys(value);
            test.log(Status.PASS, "Text value '"+ value +"' sent to element: " + elemName);
        }
        catch (Exception e) {
            test.log(Status.FAIL, e + "Failed to send text to element: " + elemName + " with value: " + value, screenShot());
            fail(e + "Failed to update text field: " + elemName);
        }
    }
}
