package test.facebookTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.facebook.LoginPageFacebook;
import pages.facebook.ProfilePageFacebook;
import test.BaseTest;
import util.Helpers;

public class LoginFacebookTest extends BaseTest {
    protected static final Logger LOGGER = Logger.getLogger(LoginFacebookTest.class);

    @Test
    public void loginAndPostTest() {
        navigate(Helpers.returnProperty("facebook.url"));

        LOGGER.info("Login into facebook");
        LoginPageFacebook loginPage = new LoginPageFacebook(driver);
        loginPage.enterCredentialsAndSubmitForm(Helpers.returnProperty("facebookUsername"), Helpers.returnProperty("facebookPassword"));

        LOGGER.info("Post and verify status");
        ProfilePageFacebook profilePageFacebook = new ProfilePageFacebook(driver);
        String status = "Hello World!";
        profilePageFacebook.postStatus(status);
        Assert.assertEquals(profilePageFacebook.getStatusText(),status);
    }
}
