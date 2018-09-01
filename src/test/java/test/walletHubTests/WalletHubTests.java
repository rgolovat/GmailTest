package test.walletHubTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wallethub.*;
import test.BaseTest;
import util.Helpers;

public class WalletHubTests extends BaseTest {
    protected static final Logger LOGGER = Logger.getLogger(WalletHubTests.class);

    @Test
    public void loginAndPostTest() {
        LOGGER.info("Navigate and login to profile");
        navigate(Helpers.returnProperty("wallethub.url"));
        LoginPageWalletHub loginPageWalletHub = new LoginPageWalletHub(driver);
        loginPageWalletHub.authorizate(Helpers.returnProperty("wallethub.username"), Helpers.returnProperty("wallethub.password"));

        PersonalProfilePageWalletHub personalProfilePageWalletHub = new PersonalProfilePageWalletHub(driver);
        String username = Helpers.returnProperty("wallethub.user") ;
        Assert.assertTrue(personalProfilePageWalletHub.usernameDisplayed(username));

        LOGGER.info("Navigate to test company profile");
        navigate("https://wallethub.com/profile/test_insurance_company/");

        LOGGER.info("Hover 5th start and click on it");
        CompanyProfilePageWalletHub companyProfilePageWalletHub = new CompanyProfilePageWalletHub(driver);
        companyProfilePageWalletHub.hoverAndClickRating(5);

        LOGGER.info("Insert Health review and check that it successfully posted");
        ReviewPageWalletHub reviewPageWalletHub = new ReviewPageWalletHub(driver);
        reviewPageWalletHub.selectFromDropDown("Health");
        reviewPageWalletHub.selectRating(5);

        String randomText = Helpers.randomString(40) + " " + Helpers.randomString(40) + " " +
                Helpers.randomString(40) + " " + Helpers.randomString(40) + " " + Helpers.randomString(40);
        reviewPageWalletHub.typeReviewAndClickSubmit(randomText);

        Assert.assertTrue(new PostedReviewPageWalletHub(driver).statusHeaderContains("Awesome"), "Status successfully posted");
        Assert.assertTrue(new PostedReviewPageWalletHub(driver).getPostedReview().equals(randomText),"Review text is thea same");

        LOGGER.info("Assert that review is present on user profile reviews page");
        navigate("https://wallethub.com/profile/" + username + "/reviews/");
        Assert.assertTrue(new ProfileReviewsPageWalletHub(driver).reviewOfCompanyExist("Test Insurance Company", randomText));



    }


}