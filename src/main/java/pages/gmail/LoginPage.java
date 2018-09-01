package pages.gmail;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;
import util.Helpers;

public class LoginPage extends BasePage {

    @FindBy(id = "identifierId")
    public WebElement loginInput;

    @FindBy(id = "identifierNext")
    public WebElement nextButton;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "passwordNext")
    public WebElement passwordNextButton;

    @Step
    public void loginAs (String username, String password){

        loginInput.sendKeys(username);
        nextButton.click();
        Helpers.pastTextWithMoveTo(driver, passwordInput, password);
        this.passwordNextButton.click();
    }

    public LoginPage(EventFiringWebDriver driver) {
        super(driver);
    }
}
