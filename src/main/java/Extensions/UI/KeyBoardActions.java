package Extensions.UI;

import Extensions.Wait;
import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.fail;

public class KeyBoardActions extends Base {

    public static void go(WebElement elem, String elemName, Keys key) {
        try {
            Wait.forElementIsClickable(elem);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
            elem.sendKeys(Keys.ENTER);
            test.log(Status.PASS, elemName + " Keyboard action done successfully");
        } catch (Exception e) {
            test.log(Status.FAIL,e + ". Failed to perform keyboard action on: " + elemName + ". Screenshot: ", screenShot());
            fail(e.getMessage() + "Failed to perform keyboard action: " + elemName);
        }
    }
}
