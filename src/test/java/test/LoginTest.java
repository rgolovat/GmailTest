package test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import util.Helpers;
import util.PropertyLoader;

public class LoginTest extends BaseTest {
  protected static final Logger LOGGER = Logger.getLogger(LoginTest.class);

  @Test
  public void loginTest() {
    LoginPage loginPage = new LoginPage(driver);

    LOGGER.info("Login into gmail");
    loginPage.loginAs(Helpers.returnProperty("userName"), Helpers.returnProperty("password"));

    LOGGER.info("Check if Compose button present");
    Assert.assertTrue(new MainPage(driver).composePresent());


  }
}
