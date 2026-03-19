package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"wrong_user",    "wrong_pass"},
                {"standard_user", "wrong_pass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage login = new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        System.out.println("Testing: " + username + " / " + password);

        if (username.equals("standard_user")
                && password.equals("secret_sauce")) {

            boolean urlCorrect = driver.getCurrentUrl()
                    .contains("inventory");
            Assert.assertTrue(urlCorrect,
                    "Valid login failed! URL: " + driver.getCurrentUrl());
            ExtentReportManager.getTest()
                    .pass("Valid login passed — URL: "
                            + driver.getCurrentUrl());

        } else {

            boolean urlCorrect = driver.getCurrentUrl()
                    .contains("inventory");
            Assert.assertFalse(urlCorrect,
                    "Invalid login should have failed!");
            ExtentReportManager.getTest()
                    .pass("Invalid login correctly rejected");
        }
    }
}