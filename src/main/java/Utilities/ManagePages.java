package Utilities;

import PageObjects.ClientsPage;
import PageObjects.LoginPage;
import org.openqa.selenium.support.PageFactory;

// Initialize Web pages
public class ManagePages extends Base{
    public static void initWeb () {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        clientsPage = PageFactory.initElements(driver, ClientsPage.class);
    }
}
