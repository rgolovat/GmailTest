package test.gmailTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gmail.LoginPage;
import pages.gmail.MainPage;
import test.BaseTest;
import util.Helpers;

public class SentReceiveTest extends BaseTest {
    protected static final Logger LOGGER = Logger.getLogger(SentReceiveTest.class);
    @Test
    public void sendReceiveTest(){
        LOGGER.info("Login into gmail");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(Helpers.returnProperty("gmail.username"), Helpers.returnProperty("gmail.password"));

        LOGGER.info("Send and verify received mail");
        MainPage mainPage = new MainPage(driver);
        mainPage.sendNewMessage(Helpers.returnProperty("gmail.username"), "hey boy", "hey girl");

        Assert.assertTrue( mainPage.verifySubjectOfFirstMessage("hey boy"));
    }
}

