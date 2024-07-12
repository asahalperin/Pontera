package Utilities;

import Interfaces.Users;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.Objects;

public class CommonOps extends Base{
    // TestNG annotation runs before test suite XML and perform everything we need to do before the test run
    @BeforeSuite
    public void startSuite() {
        if (users().platform().equals("UI")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
            ManagePages.initWeb();
        }
        extent = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter("Reports/" + timeStamp + "/Report.html");
        extent.attachReporter(extentSparkReporter);
    }

    // TestNG annotation runs after test suite XML and perform everything we need to do after the test run
    @AfterSuite
    public void afterTestSuite() {
        if (users().platform().equals("UI"))
            driver.close();
        extent.flush();
    }

    // TestNG annotation runs before every test method and perform everything we need to do before each test
    @BeforeMethod
    public void beforeTestMethod(Method method) {
        name = method.getAnnotation(Test.class).testName();
        test = extent.createTest(name);
        if (users().platform().equals("UI")) {
            driver.get(users().url() + "/business/auth/signin.html");
        }
    }

    // TestNG annotation runs after every test method and perform everything we need to do after each test
    @AfterMethod
    public void afterTestMethod(ITestResult result) {
        int status = result.getStatus();
        if (status == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test passed!");
        } else if (status == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed...");
        }
    }

    // Generate browser screenshot in Base64 format in every fail
    public static Media screenShot() {
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        Media storedImage = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
        return storedImage;
    }

    // Method to collect user data from properties file throw Users interface
    public static Users users() {
        return ConfigFactory.create(Users.class);
    }
}
