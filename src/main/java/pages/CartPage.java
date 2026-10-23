package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By XLink = By.cssSelector("a[data-test='social-x']");
    private By faceBookLink = By.cssSelector("a[data-test='social-facebook']");
    private By linkedInLink = By.cssSelector("a[data-test='social-linkedin']");
    private By itemQuantity = By.cssSelector("div[data-test='item-quantity']");
    private By backPackProduct = By.xpath("(//div[@data-test='inventory-item-name'])[1]");
    private By boltTShirtProduct = By.xpath("(//div[@data-test='inventory-item-name'])[2]");
    private By onesieProduct = By.xpath("(//div[@data-test='inventory-item-name'])[3]");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By contiue = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private String switchToNewWindow(String originalWindow) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return originalWindow;
    }

    public void clickXlink(){
        String original = driver.getWindowHandle();
        driver.findElement(XLink).click();
        switchToNewWindow(original);
    }

    public void clickFaceBookLink(){
        String original = driver.getWindowHandle();
        driver.findElement(faceBookLink).click();
        switchToNewWindow(original);
    }
    public void clickLinkedInLink() {
        String original = driver.getWindowHandle();
        driver.findElement(linkedInLink).click();
        switchToNewWindow(original);
    }
    public String getCurrentPageUrl() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("about:blank")));
        return driver.getCurrentUrl();
    }
    public int getItemQuantity(){
        return driver.findElements(itemQuantity).size();
    }
    public String getBackPackProductName(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(backPackProduct)).getText();
    }
    public String getBoltTShirtProductName(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(boltTShirtProduct)).getText();
    }
    public String getOnesieProductName(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(onesieProduct)).getText();
    }
    public void removeBackPackProduct(){
        driver.findElement(removeButton).click();
    }
    public InventoryPage continueShopping(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(contiue)).click();
        return new InventoryPage(driver);
    }


}
