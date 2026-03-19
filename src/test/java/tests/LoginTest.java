package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class LoginTest extends BaseTest {

   /* @Test(priority = 1, groups = "smoke")
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 2, groups = "regression")
    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.enterUsername("wrong_user");
        login.enterPassword("wrong_pass");
        login.clickLogin();

        Assert.assertFalse(driver.getCurrentUrl().contains("inventory"));
    }
*/
   /* @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"wrong_user", "wrong_pass"},
                {"standard_user", "wrong_pass"}
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        System.out.println("Testing with: " + username + " / " + password);
    }*/

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"wrong_user", "wrong_pass"},
                {"standard_user", "wrong_pass"}
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        if(username.equals("standard_user") && password.equals("secret_sauce")) {

            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
            System.out.println("Valid login passed");

        } else {

            Assert.assertFalse(driver.getCurrentUrl().contains("inventory"));
            System.out.println("Invalid login handled");
        }
    }




}