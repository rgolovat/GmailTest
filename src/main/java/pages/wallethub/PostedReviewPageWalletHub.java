package pages.wallethub;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

public class PostedReviewPageWalletHub extends BasePage {

    public PostedReviewPageWalletHub(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    protected WebElement statusHeader;

    @FindBy(xpath = "//*[@id='reviewform']/div[2]/p")
    protected WebElement reviewContent;

    public boolean statusHeaderContains(String status){
       return statusHeader.getText().contains(status);
    }

    public String getPostedReview(){
        return reviewContent.getText();
    }
}
