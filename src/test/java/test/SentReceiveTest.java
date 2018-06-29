package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import util.Helpers;

public class SentReceiveTest extends BaseTest {

    @Test
    public void sendReceiveTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(Helpers.returnProperty("userName"), Helpers.returnProperty("password"));

        MainPage mainPage = new MainPage(driver);
        mainPage.sendNewMessage(Helpers.returnProperty("userName"), "hey boy", "hey girl");

        Assert.assertTrue( mainPage.verifySubjectOfFirstMessage("hey boy"));
    }
}

