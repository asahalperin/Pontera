package Extensions;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.testng.Assert.fail;

public class Wait extends Base {

    //Fluent wait until element is clickable. ping every 350ms upTo required limit in seconds
    public static void ForElementIsClickable(WebElement elem, int millisSeconds) {
        try {
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofMillis(millisSeconds))
                    .pollingEvery(Duration.ofMillis(350))
                    .withMessage("Fluent wait to element '" + elem + "' to be visible")
                    .ignoring(NoSuchElementException.class, AssertionError.class).ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage());
            fail(e.getMessage());
        }
    }
}
