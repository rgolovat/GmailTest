package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Helpers {


    public static void pastTextWithMoveTo (WebDriver driver, WebElement element, String inputString ) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(inputString);
        actions.build().perform();
    }

    public static void moveAndClick (WebDriver driver, WebElement element ) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click().perform();
    }

    public static boolean elementIsPresent(WebElement element){
      return  element.isDisplayed();
    }


    public static void pressEnter(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public  static String returnProperty(String name){
        try {
            return PropertyLoader.loadProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clickWithJS(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.querySelector(\"div[aria-label='Delete']\").click();");
    }
}
