package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup(Method method) {

        // Driver setup
        String browser = ConfigReader.get("browser");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("base.url"));

        // ExtentReports — test start
        com.aventstack.extentreports.ExtentTest extentTest =
                ExtentReportManager.getInstance()
                        .createTest(method.getName());
        ExtentReportManager.setTest(extentTest);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // ExtentReports — result log karo
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.takeScreenshot(driver, result.getName());
            ExtentReportManager.getTest()
                    .fail(result.getThrowable());

        } else if (ITestResult.SUCCESS == result.getStatus()) {
            ExtentReportManager.getTest().pass("Test Passed");

        } else {
            ExtentReportManager.getTest().skip("Test Skipped");
        }

        // Report save karo
        ExtentReportManager.getInstance().flush();

        // Browser band karo
        if (driver != null) {
            driver.quit();
        }
    }
}