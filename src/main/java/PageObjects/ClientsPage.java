package PageObjects;

import Extensions.*;
import Extensions.UI.Click;
import Extensions.UI.KeyBoardActions;
import Extensions.UI.Update;
import Utilities.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static Utilities.CommonOps.users;

public class ClientsPage extends Base {

    @FindBy(id = "addNewClientBtnId")
    static WebElement addNewClient;

    @FindBy(id = "first_name")
    static WebElement firstNameField;

    @FindBy(id = "last_name")
    static WebElement lastNameField;

    @FindBy(id = "ssn")
    static WebElement ssnField;

    @FindBy(id = "email")
    static WebElement emailField;

    @FindBy(id = "contactPhone")
    static WebElement mobilePhoneField;

    @FindBy(id = "city")
    static WebElement cityField;

    @FindBy(xpath = "//div[text()='Select state']")
    static WebElement stateOptions;

    @FindBy(xpath = "//div[text()='Select Advisor']")
    static WebElement advisorDropDown;

    @FindBy(id = "save-client-changes-btn")
    static WebElement addClientButton;

    @FindBy(id = "beadcrumbs-email-li-id")
    static WebElement beadcrumbsEmail;

    @FindBy(xpath = "//option[text()='Alabama']")
    static WebElement alabama;

    @FindBy(xpath = "//option[text()='Maayan Tester1']")
    static WebElement maayanTester1;

    @FindBy(xpath = "//span[text() = 'Name:']/following-sibling::*")
    static WebElement finalClientName;

    @FindBy(xpath = "//*[@id='my-clients']/table/tbody/tr/td/a")
    static List<WebElement> clients;

    @FindBy(xpath = "//*[@id='my-clients']/table/tbody/tr/td/a")
    static WebElement client;

    @FindBy(id = "some-input")
    static WebElement searchClientField;

    @FindBy(xpath = "//td/*[text() = 'Maayan Tester1']")
    static WebElement currentClient;

    @FindBy(name = "userActionFeedbackForm")
    static WebElement removeClientPopup;

    @FindBy(id = "feedback5")
    static WebElement answerOtherRadioButton;

    @FindBy(id = "my-clients")
    static WebElement myClientsArea;

    @FindBy(id = "delete-client-id")
    static WebElement deleteClientButton;
    public static void addClient(String firstName, String lastName) {
        Click.go(addNewClient, "Add new client button");
        Update.text(firstNameField, firstName, "First name field");
        Update.text(lastNameField, lastName, "Last name field");
        Update.text(ssnField, "111111111", "SSN field");
        Update.text(emailField, users().clientEmail(), " Email field");
        Update.text(mobilePhoneField, users().mobilePhone(), "Mobile phone field");
        Update.text(cityField, users().city(), "City field");
        Click.go(stateOptions,"State options button");
        Click.go(alabama, "Alabama");
        Click.go(advisorDropDown, "Advisor name options");
        Click.go(maayanTester1, "Maayan Tester1");
        Click.go(addClientButton, "Add client button");
        Wait.untilElementTextIsNotEqual(finalClientName, "--");
        Verify.elementTextEqual(finalClientName, users().firstName() + " " + users().lastName());
    }

    public static void deleteClient() throws InterruptedException {
        Click.go(currentClient, "Current client button");
        Click.go(deleteClientButton, "Delete client button");
        Verify.elementExists(removeClientPopup, "Remove client Popup");
        Click.go(answerOtherRadioButton, "Answer 'Other' radio button");
        Thread.sleep(500);
        KeyBoardActions.go(answerOtherRadioButton, "Answer radio button", Keys.ENTER);
        Verify.elementExists(myClientsArea, "MyClientsArea");
    }

    public static boolean verifyClientInGrid() {
        boolean isEqual = true;
        if (!driver.getCurrentUrl().contains("qaa/advisor/clients")) {
            driver.get(users().url() + "/qaa/advisor/clients");
            Wait.forElementIsClickable(client);
        }
        String clientText = null;
        for (WebElement client : clients) {
            clientText = client.getText();
            if (!clientText.equals(users().firstName() + " " + users().lastName())) {
                isEqual = false;
            } else {
                isEqual = true;
                break;
            }
        }
        return isEqual;
    }
}
