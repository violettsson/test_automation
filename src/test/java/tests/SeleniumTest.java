package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class SeleniumTest {

    protected WebDriver driver;


    @BeforeTest
    void startServer() {

        System.setProperty("webdriver.chrome.driver", "/Users/Purferno/Downloads/chromedriver_74");

        DesiredCapabilities caps = DesiredCapabilities.chrome();

        driver = new ChromeDriver(caps);

        driver.get("http://cafetownsend-angular-rails.herokuapp.com");
    }
}
