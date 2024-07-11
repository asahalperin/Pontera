package Tests;

import PageObjects.ClientsPage;
import PageObjects.LoginPage;
import Utilities.CommonOps;
import org.testng.annotations.Test;

public class AddClients extends CommonOps {

    // Validate new client is added = Valid
    @Test(testName = "Add new client - Valid")
    public static void addNewClientValid() {
        LoginPage.signIn(users().email(), users().password());
        LoginPage.selectFirm(users().firm());
        ClientsPage.addClient(users().advisorFirstName(), users().advisorLastName());
        ClientsPage.verifyClientInGrid();
    }

//    // Validate new client is added = InValid email
//    @Test(testName = "Add new client - InValid email")
//    public static void addNewClientInValidEmail() {
//        LoginPage.SignIn(users().email() + "1", users().password());
//        LoginPage.selectFirm(users().firm());
//    }
//
//    // Validate new client is added = InValid password
//    @Test(testName = "Add new client - InValid password")
//    public static void addNewClientInValidPassword() {
//        LoginPage.SignIn(users().email(), users().password() + "1");
//        LoginPage.selectFirm(users().firm());
//    }
//
//    // Validate new client is added = InValid firm
//    @Test(testName = "Add new client - InValid firm")
//    public static void addNewClientInValidFirm() {
//        LoginPage.SignIn(users().email(), users().password());
//        LoginPage.selectFirm(users().firm() + 1);
//    }
}
