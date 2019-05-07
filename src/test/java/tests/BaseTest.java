package tests;


import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected NgWebDriver ngWebDriver;

    @BeforeClass
    public void startServer() {
        System.setProperty("webdriver.chrome.driver", "/Users/Purferno/Downloads/chromedriver_74");
        DesiredCapabilities caps = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

        driver.get("http://cafetownsend-angular-rails.herokuapp.com");
        ngWebDriver.waitForAngularRequestsToFinish();


    }

    @AfterClass
    public int stopServer() {
        driver.quit();
        return 0;
    }
}
