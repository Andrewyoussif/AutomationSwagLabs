package login;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.DataDriven;

import static org.testng.Assert.*;

public class InvalidUsernameAndPassword extends BaseTests {
    @Test
    public void invalidUsernameAndPassword(){
        String username = DataDriven.jsonReader("invalidUser","username");
        String password= DataDriven.jsonReader("invalidUser","password");
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        String message = loginPage.getErrorMessage();
        assertTrue(message.contains("Username and password do not match") ,"Wrong Content");
    }
}
