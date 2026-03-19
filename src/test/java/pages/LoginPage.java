package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class LoginPage {

    private WebDriver driver;
    private WaitUtil waitUtil;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public void enterUsername(String username) {
        waitUtil.waitForVisible(usernameField).clear();
        waitUtil.waitForVisible(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtil.waitForVisible(passwordField).clear();
        waitUtil.waitForVisible(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waitUtil.waitForClickable(loginBtn).click();
    }

    public String getErrorMessage() {
        return waitUtil.waitForVisible(errorMsg).getText();
    }
}