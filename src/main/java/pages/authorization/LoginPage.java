package pages.authorization;

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

    @FindBy(xpath = "//*[@ng-model='user.name']")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@ng-model='user.password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;



    public LoginPage inputCredentials(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }


    public HomePage login(String email, String password) throws Exception {
        inputCredentials(email, password);
        buttonLogin.click();
        return new HomePage(driver);
    }
}
