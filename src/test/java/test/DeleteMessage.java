package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import util.Helpers;


public class DeleteMessage extends BaseTest {

    @Test
    public void deleteMessageTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(Helpers.returnProperty("userName"), Helpers.returnProperty("password"));

        MainPage mainPage = new MainPage(driver);
        mainPage.sendNewMessage(Helpers.returnProperty("userName"), "hey boy", "hey girl");

        mainPage.deleteMessageWithSubject("hey boy");

        Assert.assertTrue( !mainPage.verifySubjectOfFirstMessage("hey boy"));
    }
}
