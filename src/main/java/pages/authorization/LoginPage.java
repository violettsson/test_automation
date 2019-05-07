package pages.authorization;

import core.model.Credentials;
import core.testing.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.home.HomePage;


public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Elements
     */
    @FindBy(xpath = "//*[@ng-model='user.name']")
    public WebElement inputUsername;

    @FindBy(xpath = "//*[@ng-model='user.password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    @FindBy(css = ".error-message")
    public WebElement errorMessage;


    /**
     * Actions
     */
    public LoginPage inputCredentials(Credentials credentials) {
        inputUsername.sendKeys(credentials.username);
        inputPassword.sendKeys(credentials.password);
        return this;
    }

    public HomePage login(Credentials credentials) throws InterruptedException {
        inputCredentials(credentials);
        buttonLogin.click();
        Thread.sleep(2000);
        return new HomePage(driver);
    }
}
