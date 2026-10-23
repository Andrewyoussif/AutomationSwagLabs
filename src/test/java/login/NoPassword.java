package login;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.TestDataDataDriven;

import static org.testng.Assert.assertTrue;

public class NoPassword extends BaseTests {
    @Test
    public void NoPassword(){
        String username = TestDataDataDriven.jsonReader("noPassword","username");
        loginPage.setUserName(username);
        loginPage.clickLogin();
        String message = loginPage.getErrorMessage();
        assertTrue(message.contains("Password is required"), "Wrong Content");
    }
}
