package pages.wallethub;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

public class LoginPageWalletHub extends BasePage {

    public LoginPageWalletHub(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@name,'em')]")
    protected WebElement emailField;

    @FindBy(xpath = "//input[contains(@name,'pw')]")
    protected WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(),'Login')]/..")
    protected WebElement loginButton;

    public void authorizate(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}

