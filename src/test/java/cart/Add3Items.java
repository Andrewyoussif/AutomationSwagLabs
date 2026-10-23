package cart;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ProductsDataDriven;

import static org.testng.Assert.assertEquals;

public class Add3Items extends BaseTests {
    private InventoryPage inventoryPage;


    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
    }

    @Test
    public void add3Items(){
        String backItem = ProductsDataDriven.jsonReader("Items","Item1");
        String boltItem = ProductsDataDriven.jsonReader("Items","Item2");
        String onesieItem = ProductsDataDriven.jsonReader("Items","Item3");
        inventoryPage.addBackPackProduct();
        inventoryPage.addBoltTShirtProduct();
        inventoryPage.addOnesieProduct();
        CartPage cartIcon = inventoryPage.clickCartIcon();
        String backPack = cartIcon.getBackPackProductName();
        String boltTshirt = cartIcon.getBoltTShirtProductName();
        String onesie = cartIcon.getOnesieProductName();
        assertEquals(backPack,backItem,"Back pack product name is incorrect.");
        assertEquals(boltTshirt,boltItem,"Bolt T-shirt product name is incorrect.");
        assertEquals(onesie,onesieItem,"Onesie product name is incorrect.");
    }
}
