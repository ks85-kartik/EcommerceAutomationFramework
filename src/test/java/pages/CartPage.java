package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class CartPage {

    private WebDriver driver;
    private WaitUtil waitUtil;

    By cartItem = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public String getCartItemName() {
        return waitUtil.waitForVisible(cartItem).getText();
    }

    public boolean isCartEmpty() {
        return driver.findElements(
                By.className("inventory_item_name")).size() == 0;
    }
}