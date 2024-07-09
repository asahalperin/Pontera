package PageObjects;

import Extensions.Click;
import Extensions.SelectFromDD;
import Extensions.Update;
import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientsPage extends Base {

    @FindBy(id = "addNewClientBtnId")
    public static WebElement addNewClient;

    @FindBy(id = "first_name")
    private static WebElement firstNameField;

    @FindBy(id = "last_name")
    private static WebElement lastNameField;

    @FindBy(id = "ssn")
    private static WebElement ssnField;

    @FindBy(id = "email")
    private static WebElement emailField;

    @FindBy(id = "contactPhone")
    private static WebElement mobilePhoneField;

    @FindBy(id = "city")
    private static WebElement cityField;

    @FindBy(xpath = "//div[text()='Select state']")
    private static WebElement stateOptions;

    @FindBy(xpath = "//div[text()='Select Advisor']")
    private static WebElement advisorDropDown;

    @FindBy(id = "save-client-changes-btn")
    private static WebElement addClientButton;

    @FindBy(id = "beadcrumbs-email-li-id")
    private static WebElement beadcrumbsEmail;

    @FindBy(xpath = "//option[text()='Alabama']")
    private static WebElement alabama;

    @FindBy(xpath = "//option[text()='Maayan Tester1']")
    private static WebElement maayanTester1;

    public static void addClient(String firstName, String lastName, String ssn, String email, String mobilePhone, String city, String state, String advisorName) {
        Click.go(addNewClient, "Add new client button", 5000);
        Update.text(firstNameField, firstName, "First name field", 5000);
        Update.text(lastNameField, lastName, "Last name field", 5000);
        Update.text(ssnField, ssn, "SSN field", 5000);
        Update.text(emailField, email, " Email field", 5000);
        Update.text(mobilePhoneField, mobilePhone, "Mobile phone field", 5000);
        Update.text(cityField, city, "City field", 5000);
        Click.go(stateOptions,"State options button", 5000);
        Click.go(alabama, "Alabama", 5000);
        Click.go(advisorDropDown, "Advisor name options", 5000);
        Click.go(maayanTester1, "Maayan Tester1", 5000);
        Click.go(addClientButton, "Add client button", 7500);
    }

}
