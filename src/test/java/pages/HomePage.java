package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class HomePage {

    private WebDriver driver;
    private WaitUtil waitUtil;

    By productTitle = By.className("title");
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By removeBtn = By.id("remove-sauce-labs-backpack");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public String getPageTitle() {
        return waitUtil.waitForVisible(productTitle).getText();
    }

    public void addProductToCart() {
        waitUtil.waitForClickable(addToCartBtn).click();
    }

    public void clickCart() {
        waitUtil.waitForClickable(cartIcon).click();
    }

    public void removeProduct() {
        waitUtil.waitForClickable(removeBtn).click();
    }
}