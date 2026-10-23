package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();

    }
    @BeforeMethod
    public void openURL(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        driver.manage().deleteAllCookies();

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
