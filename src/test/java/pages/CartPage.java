package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartItem = By.className("inventory_item_name");

    public String getCartItemName() {
        return driver.findElement(cartItem).getText();
    }
    public boolean isCartEmpty() {
        return driver.findElements(By.className("inventory_item_name")).size() == 0;
    }
}