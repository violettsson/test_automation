package tests.authorization;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import pages.authorization.LoginPage;
import tests.SeleniumTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends SeleniumTest {


    @Test
    void loginTest() throws Exception{

        System.setProperty("webdriver.chrome.driver", "/Users/Purferno/Downloads/chromedriver_74");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        driver = new ChromeDriver(caps);
        driver.get("http://cafetownsend-angular-rails.herokuapp.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Luke", "Skywalker").moveToCreation();
    }
}
