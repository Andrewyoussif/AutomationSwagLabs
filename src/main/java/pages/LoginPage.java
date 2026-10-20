package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test*='error']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public InventoryPage clickLogin(){
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }
    public String getErrorMessage( ){
        return driver.findElement(errorMessage).getText();
    }

}
