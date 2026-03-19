package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By productTitle = By.className("title");

    public String getPageTitle() {
        return driver.findElement(productTitle).getText();
    }
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }
    By removeBtn = By.id("remove-sauce-labs-backpack");

    public void removeProduct() {
        driver.findElement(removeBtn).click();
    }
}