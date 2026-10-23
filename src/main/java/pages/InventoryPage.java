package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By itemNumber = By.className("inventory_item");
    private By cartIcon = By.id("shopping_cart_container");
    private By cartLink = By.cssSelector("a[data-test='shopping-cart-link']");
    private By backPackProduct = By.xpath("//button[contains(@name,'sauce-labs-backpack')]");
    private By boltTShirtProduct = By.xpath("//button[contains(@name,'sauce-labs-bolt-t-shirt')]");
    private By onesieProduct = By.xpath("//button[contains(@name,'sauce-labs-onesie')]");
    public InventoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public CartPage clickCartIcon(){
         driver.findElement(cartLink).click();
         return new CartPage(driver);
    }
    public void addBackPackProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(backPackProduct)).click();
    }
    public void addOnesieProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(onesieProduct)).click();
    }
    public void addBoltTShirtProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(boltTShirtProduct)).click();
    }
    public String getBackPackButtonText(){
        return  driver.findElement(backPackProduct).getText();
    }
    public String getBoltTShirtButtonText(){
        return  driver.findElement(boltTShirtProduct).getText();
    }
    public String getOnesieButtonText(){
        return  driver.findElement(onesieProduct).getText();
    }


}
