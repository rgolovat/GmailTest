package test.gmailTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gmail.LoginPage;
import pages.gmail.MainPage;
import test.BaseTest;
import util.Helpers;

public class LoginTest extends BaseTest {
  protected static final Logger LOGGER = Logger.getLogger(LoginTest.class);

  @Test
  public void loginTest() {
    navigate(Helpers.returnProperty("gmail.url"));

    LOGGER.info("Login into gmail");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.loginAs(Helpers.returnProperty("gmail.username"), Helpers.returnProperty("gmail.password"));

    LOGGER.info("Check if Compose button present");
    Assert.assertTrue(new MainPage(driver).composePresent());


  }
}
