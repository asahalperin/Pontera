package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static Utilities.CommonOps.screenShot;
import static org.testng.AssertJUnit.fail;


public class SelectFromDD extends Base {

    public static void byVisibleText(WebElement elem, String visibleText, String elemName) {
        try {
            Wait.forElementIsClickable(elem);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
            Select dropdown = new Select(elem);
            dropdown.selectByVisibleText(visibleText);
            test.log(Status.PASS, "Text: '" + visibleText + "' selected successfully from element " + elemName);
        } catch (Exception e) {
            test.log(Status.FAIL,e + ". Failed to select text: '" + visibleText + "' from element: " + elemName + ". Screenshot: ", screenShot());
            fail(e.getMessage() + "Failed to select: " + elemName);
        }
    }
}
