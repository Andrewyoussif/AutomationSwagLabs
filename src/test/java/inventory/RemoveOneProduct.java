package inventory;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class RemoveOneProduct extends BaseTests {
    private InventoryPage inventoryPage;
    private CartPage cartpage;

    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
        inventoryPage.addBackPackProduct();
        inventoryPage.addBoltTShirtProduct();
        inventoryPage.addOnesieProduct();
        cartpage = inventoryPage.clickCartIcon();
    }

    @Test
    public void removeOneProduct(){
        cartpage.removeBackPackProduct();
        inventoryPage = cartpage.continueShopping();
        assertEquals(inventoryPage.getBackPackButtonText(),"Add to cart",
                "Incorrect back pack button text");
        assertEquals(inventoryPage.getBoltTShirtButtonText(),"Remove",
                "Incorrect bolt T-shirt button text");
        assertEquals(inventoryPage.getOnesieButtonText(),"Remove",
                "Incorrect Onesie button text");
    }
}
