package PageObjects;

import Extensions.*;
import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static PageObjects.ClientsPage.addNewClient;
import static org.testng.Assert.fail;

public class LoginPage extends Base {

    // Relevant Web elements for the tests
    @FindBy(id = "loginEmail")
    private static WebElement emailField;

    @FindBy(id = "loginPassword")
    private static WebElement passwordField;

    @FindBy(xpath = "//*[@id='loginForm']/*/*[@type='submit']")
    private static WebElement logInButton;

    @FindBy(id = "orgId")
    private static WebElement firmDropDown;

    // Sign in workflow using current class elements
    public static void signIn(String email, String password) {
        Update.text(emailField, email,"Email field", 5000);
        Update.text(passwordField, password,"Password field", 5000);
        Click.go(logInButton, "Login button", 7500);
        Verify.elementExists(firmDropDown, "Firm drop down", 5000);
    }

    public static void selectFirm(String visibleText) {
        SelectFromDD.byVisibleText(firmDropDown, visibleText, "Firm drop down", 5000);
        Click.go(logInButton, "Login button", 7500);
        Verify.elementExists(addNewClient, "Add new client button", 5000);
    }
}
