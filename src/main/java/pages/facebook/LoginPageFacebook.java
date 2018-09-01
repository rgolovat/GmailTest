package pages.facebook;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

public class LoginPageFacebook extends BasePage {
    protected static final Logger LOGGER = Logger.getLogger(LoginPageFacebook.class);

    public LoginPageFacebook(EventFiringWebDriver driver) {super(driver);
    }
    @FindBy(name = "email")
    protected WebElement inputEmailId;

    @FindBy(name = "pass")
    protected WebElement inputPassword;

    @FindBy(id = "loginbutton")
    protected WebElement submitLogin;



    public void enterCredentialsAndSubmitForm(String email, String password) {
        LOGGER.info("Entering credentials 'email', 'password' and submitting form");
        inputEmailId.sendKeys(email);
        inputPassword.sendKeys(password);
        clickSubmitLoginButton();
    }

    public void clickSubmitLoginButton() {
        LOGGER.info("Clicking the 'submit' button");
        submitLogin.click();
    }

}
