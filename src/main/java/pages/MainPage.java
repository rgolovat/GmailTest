package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import util.Helpers;

import javax.xml.ws.handler.HandlerResolver;
import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'COMPOSE')]")//div[@id=':j0']/div/div")
    private WebElement composeButton;

    @FindBy(how = How.XPATH, using = "//div[@aria-label='Delete']/div")
    private WebElement deleteButton;

    @FindBy(how = How.XPATH, using = ".//textarea[contains(@aria-label, 'To')]")
    private WebElement sentToInput;

    @FindBy(how = How.NAME, using = "subjectbox")
    private WebElement subjectInput;

    @FindBy(how = How.XPATH, using = "//div[@style='display: block;']/div[@aria-label='Message Body']")
    private WebElement messageInput;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Send') and @role='button' ]")
    private WebElement sendButton;

    @FindBys({ @FindBy(how =How.XPATH, using = "//div[@role='tabpanel']//tbody/tr")})
    private List<WebElement> listIncomeMessages;

    @FindBy(how = How.XPATH, using = "//a[@href='https://mail.google.com/mail/u/0/#inbox']")
    private WebElement inputMessagesButton;

    public boolean composePresent() {
        return Helpers.elementIsPresent(composeButton);
    }

    public WebElement firstIncomeMessage(){
        return listIncomeMessages.get(0);
    }

    @Step
    public boolean verifySubjectOfFirstMessage(String subject) {
        inputMessagesButton.click();

        return firstIncomeMessage().getText().contains(subject);
    }

    @Step
    public void sendNewMessage(String receiver, String subject, String message) {
        composeButton.click();

        Helpers.pastTextWithMoveTo(driver, sentToInput, receiver);
        Helpers.pressEnter();

        Helpers.pastTextWithMoveTo(driver, subjectInput, subject);
        Helpers.pastTextWithMoveTo(driver, messageInput, message);
        sendButton.click();
    }
    @Step
    public void deleteMessageWithSubject(String subject){
        if(verifySubjectOfFirstMessage(subject)){
            firstIncomeMessage().findElement(By.xpath("//span/b[contains(text(),'" + subject + "')]")).click();
            Helpers.moveAndClick(driver, deleteButton);
        }



    }

}
