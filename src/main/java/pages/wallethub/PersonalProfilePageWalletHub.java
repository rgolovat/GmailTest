package pages.wallethub;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

public class PersonalProfilePageWalletHub extends BasePage {

    public PersonalProfilePageWalletHub(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(className = "username")
    protected WebElement userName;

    public boolean usernameDisplayed(String username){
        return userName.getText().contains(username);
    }
}
