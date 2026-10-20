package inventory;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class InventoryTests extends BaseTests {
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
    }

    @Test
    public void validTitle(){
        String title = inventoryPage.getTitle();
        assertEquals(title,"Swag Labs","Title is incorrect.");
    }

    @Test
    public void validCartIcon(){
        boolean carticon = inventoryPage.isCartDisplayed();
        assertEquals(carticon,true,"CartIcon is not dispalyed.");
    }

    @Test
    public void validProductsNumber(){
        int numberOfItems = inventoryPage.getItemsNumber();
        assertEquals(numberOfItems,6,"Items number is incorrect.");
    }
}
