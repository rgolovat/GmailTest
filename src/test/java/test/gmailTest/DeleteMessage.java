package test.gmailTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gmail.LoginPage;
import pages.gmail.MainPage;
import test.BaseTest;
import util.Helpers;


public class DeleteMessage extends BaseTest {
    protected static final Logger LOGGER = Logger.getLogger(BaseTest.class);


    @Test
    public void deleteMessageTest(){
        navigate(Helpers.returnProperty("gmail.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(Helpers.returnProperty("gmail.username"), Helpers.returnProperty("gmail.password"));

        MainPage mainPage = new MainPage(driver);
        mainPage.sendNewMessage(Helpers.returnProperty("gmail.username"), "hey boy", "hey girl");

        mainPage.deleteMessageWithSubject("hey boy");

        Assert.assertTrue( !mainPage.verifySubjectOfFirstMessage("hey boy"));
    }
}
