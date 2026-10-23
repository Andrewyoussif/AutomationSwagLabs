package login;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.TestDataDataDriven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ValidLogin extends BaseTests {

    @Test
    public void validloginTest(){
        String username = TestDataDataDriven.jsonReader("validUser","username");
        String password= TestDataDataDriven.jsonReader("validUser","password");
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        var HomePage = loginPage.clickLogin();
        String title = HomePage.getTitle();
        assertEquals(title, "Swag Labs" , "Incorrect Title");
    }
}
