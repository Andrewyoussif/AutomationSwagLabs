package cart;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class CartIsEmpty extends BaseTests {

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
    public void emptyCartIsEmpty(){
        int items = cartPage.getItemQuantity();
        assertEquals(items,0,"Item quantity not Empty");

    }
}
