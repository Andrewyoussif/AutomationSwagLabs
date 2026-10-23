package cart;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class SocialLinks extends BaseTests {
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
          cartPage = inventoryPage.clickCartIcon();

    }
    @Test
    public void verifySocialLinks() {

        cartPage = new CartPage(driver);
        String original = driver.getWindowHandle();

        cartPage.clickLinkedInLink();
        assertTrue(cartPage.getCurrentPageUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(original);

        cartPage.clickFaceBookLink();
        assertTrue(cartPage.getCurrentPageUrl().contains("facebook"));
        driver.close();
        driver.switchTo().window(original);

        cartPage.clickXlink();
        assertTrue(cartPage.getCurrentPageUrl().contains("x.com"));
        driver.close();
        driver.switchTo().window(original);
    }
//    @Test
//    public void XLinkVerify(){
//        cartPage.clickXlink();
//        String Xurl = cartPage.getXURL();
//        assertTrue(Xurl.contains("x.com"),"Incorrect XURL");
//    }
//    @Test
//    public void faceBookLinkVerify(){
//        cartPage.clickFaceBookLink();
//        String facebookurl = cartPage.getFaceBookURL();
//        assertTrue(facebookurl.contains("Facebook"),"Incorrect facebookURL");
//    }
//    @Test
//    public void linkedinLinkVerify(){
//        cartPage.clickLinkedInLink();
//        String linkedinurl = cartPage.getLinkedInURL();
//        assertTrue(linkedinurl.contains("LinkedIn"),"Incorrect XURL");
//    }
}
