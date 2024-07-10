package PageObjects;

import Extensions.*;
import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static PageObjects.ClientsPage.addNewClient;

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
        Update.text(emailField, email,"Email field");
        Update.text(passwordField, password,"Password field");
        Click.go(logInButton, "Login button");
        Verify.elementExists(firmDropDown, "Firm drop down");
    }

    public static void selectFirm(String visibleText) {
        SelectFromDD.byVisibleText(firmDropDown, visibleText, "Firm drop down");
        Click.go(logInButton, "Login button");
        Verify.elementExists(addNewClient, "Add new client button");
    }
}
