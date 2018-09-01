package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class BasePage {

  protected EventFiringWebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public BasePage(EventFiringWebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }


}
