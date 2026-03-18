package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();



        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("--guest");

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");


    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}