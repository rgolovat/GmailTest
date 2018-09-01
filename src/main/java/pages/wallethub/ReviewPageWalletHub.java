package pages.wallethub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.BasePage;

public class ReviewPageWalletHub extends BasePage {

    public ReviewPageWalletHub(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(className = "dropdown-list-new")
    protected WebElement dropdown;

    @FindBy(id = "review-content")
    protected WebElement reviewField;

    @FindBy(xpath = "//input[contains(@value,'Submit')]")
    protected WebElement submitButton;

    @FindBy(id = "overallRating")
    protected WebElement overallRating;


    public void selectFromDropDown(String option){
        dropdown.click();
        WebElement selectedOption = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
        selectedOption.click();
    }

    public void selectRating(int ratingLevel){
        WebElement ratingStar = driver.findElement(By.xpath("//*[@id='overallRating']/a[" + ratingLevel + "]"));
        ratingStar.click();
    }

    public void typeReviewAndClickSubmit(String review){
        reviewField.clear();
        reviewField.sendKeys(review);
        submitButton.click();
    }


}
