package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.Helpers;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "identifierId")
    public WebElement loginInput;

    @FindBy(how = How.ID, using = "identifierNext")
    public WebElement nextButton;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "passwordNext")
    public WebElement passwordNextButton;

    @Step
    public void loginAs (String username, String password){

        loginInput.sendKeys(username);
        nextButton.click();
        Helpers.pastTextWithMoveTo(driver, passwordInput, password);
        this.passwordNextButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
