package pages.wallethub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import pages.BasePage;

public class CompanyProfilePageWalletHub extends BasePage {
    public CompanyProfilePageWalletHub(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(className = "wh-rating-notes")
    protected WebElement rattingBar;

    @FindBy(className = "wh-rating-choices")
    protected WebElement ratingChoicesBar;

    public void hoverAndClickRating(int ratingLevel){

        Actions action = new Actions(driver.getWrappedDriver());
        action.moveToElement(rattingBar);
        action.perform();
        for(int i = 1; i<= ratingLevel; i++) {

            WebElement ratingStar = ratingChoicesBar.findElement(By.xpath("//a[contains(text(),'" + i + "')]"));
            if (i <= 4) {
                action.moveToElement(ratingStar).build().perform();
                String classes = ratingStar.getAttribute("class");
                Assert.assertTrue(classes.equals("hover"), String.format("Assert that start %s is hovered", i));
            }
            else {
                action.moveToElement(ratingStar).click();
                action.perform();
            }
        }
    }


}
