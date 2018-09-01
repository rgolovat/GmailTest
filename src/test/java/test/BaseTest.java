package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import ru.stqa.selenium.factory.WebDriverPool;
import util.EventListener;
import util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class BaseTest {

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    private WebDriver webDriver;
    protected EventFiringWebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        capabilities = PropertyLoader.loadCapabilities();
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
    }

    @BeforeMethod
        public void initWebDriver() {
        URL url = null;
        try {
            url = new URL(gridHubUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webDriver = WebDriverPool.DEFAULT.getDriver(url,capabilities);
        setupEventListener();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    private void setupEventListener(){
        driver = new EventFiringWebDriver(webDriver);
        EventListener eventListener = new EventListener();
        driver.register(eventListener);
        driver.manage().window().maximize();
    }

    public void navigate(String url){
        driver.navigate().to(url);
    }
}
