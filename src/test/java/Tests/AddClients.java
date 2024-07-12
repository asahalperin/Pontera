package Tests;

import Extensions.Verify;
import PageObjects.ClientsPage;
import PageObjects.LoginPage;
import Utilities.CommonOps;
import org.testng.annotations.Test;

public class AddClients extends CommonOps {

    // Validate new client is added = Valid
    @Test(priority = 4, testName = "Add new client - Valid")
    public static void addNewClientValid() {
        LoginPage.signIn(users().email(), users().password());
        LoginPage.selectFirm(users().firm());
        ClientsPage.addClient(users().firstName(), users().lastName());
        Verify.generalBoolean(ClientsPage.verifyClientInGrid(), "New client name: '" + users().firstName() + "a " + users().lastName() + "' exist in client grid");
    }

    // Validate new created is added = Valid (Skipped if Create client fails)
    @Test(dependsOnMethods = "addNewClientValid", priority = 5, testName = "Deleted new client - Valid")
    public static void deleteNewClientValid() throws InterruptedException {
        ClientsPage.deleteClient();
        Thread.sleep(500);
        Verify.generalBoolean(!ClientsPage.verifyClientInGrid(), "New client name: '" + users().firstName() + "a " + users().lastName() + "' is not exist in client grid");
    }

    // Validate new client is added = InValid email
    @Test(priority = 1, testName = "Add new client - InValid email")
    public static void addNewClientInValidEmail() {
        LoginPage.signIn(users().email() + "1", users().password());
        LoginPage.selectFirm(users().firm());
    }

    // Validate new client is added = InValid password
    @Test(priority = 2, testName = "Add new client - InValid password")
    public static void addNewClientInValidPassword() {
        LoginPage.signIn(users().email(), users().password() + "1");
        LoginPage.selectFirm(users().firm());
    }

    // Validate new client is added = InValid firm
    @Test(priority = 3, testName = "Add new client - InValid firm")
    public static void addNewClientInValidFirm() {
        LoginPage.signIn(users().email(), users().password());
        LoginPage.selectFirm(users().firm() + 1);
    }
}
