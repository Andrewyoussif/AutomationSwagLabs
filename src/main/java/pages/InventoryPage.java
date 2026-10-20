package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private By itemNumber = By.className("inventory_item");
    private By cartIcon = By.id("shopping_cart_container");
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public int getItemsNumber(){
        return driver.findElements(itemNumber).size();
    }
    public boolean isCartDisplayed(){
        return driver.findElement(cartIcon).isDisplayed();
    }
}
