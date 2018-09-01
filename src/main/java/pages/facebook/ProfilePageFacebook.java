package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

public class ProfilePageFacebook extends BasePage {

    public ProfilePageFacebook(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@name='xhpc_message']")
    protected WebElement statusField;

    @FindBy(xpath = "//button[contains(@data-testid,'react-composer-post-button')]")
    protected WebElement shareButton;


    @FindBy(xpath = "//div[contains(@class,'userContent ')]")
    protected WebElement statusTextField;

    public void postStatus(String message){
        statusField.sendKeys(message);
        shareButton.click();
    }

    public String getStatusText(){
        return  statusTextField.getText();
    }



}
