package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.fail;

public class Wait extends Base {

    //Fluent wait until element is clickable. ping every 350ms upTo required limit in seconds
    public static void forElementIsClickable(WebElement elem) {
        try {
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofMillis(20000))
                    .pollingEvery(Duration.ofMillis(1000))
                    .withMessage("Fluent wait to element '" + elem + "' to be visible")
                    .ignoring(NoSuchElementException.class, AssertionError.class).ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage());
            fail(e.getMessage());
        }
    }

    public static void untilElementTextIsNotEqual(WebElement elem, String textToSkip) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
            // Wait until the text of the element is not equal to "--"
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return !elem.getText().equals(textToSkip);
                }
            });
            test.log(Status.PASS, "Wait until element text is not equal to: '" + textToSkip + "' successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Wait until element text is not equal to: '" + textToSkip + "' is failed", screenShot());
            fail(e.getMessage());
        }
    }
}
