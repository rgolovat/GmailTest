package pages.wallethub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

import java.util.List;

public class ProfileReviewsPageWalletHub extends BasePage {

    public ProfileReviewsPageWalletHub(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBys(@FindBy(className = "review"))
    protected List<WebElement> reviewsList;




    public boolean reviewOfCompanyExist(String companyName, String reviewText){
        for(WebElement review : reviewsList){
            String company = review.findElement(By.className("profile-company-name")).getText();
            if (company.equals(companyName)) {
                String text = review.findElement(By.tagName("p")).getText();
                return text.equals(reviewText);
            }
        }
        return false;
    }
}
