package tests.authorization;

import core.model.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.LoginPage;
import pages.home.HomePage;
import tests.BaseTest;
import tests.Input;

public class AuthorizationTest extends BaseTest {

    @Test(priority = 0)
    void login_with_valid_creds_test() throws InterruptedException {
        String greetingsText = "Hello Luke";
        Credentials creds = Input.credentials.valid;
        HomePage homePage = new LoginPage(driver).login(creds);

        String greetingsTextLocator = homePage.greetings.getText();
        Assert.assertTrue(greetingsTextLocator.contains(greetingsText), "'Hello Luke' text is not found");
    }

    @Test(priority = 1)
    void logout_test() {
        LoginPage loginPage = new HomePage(driver).logout();

        boolean buttonLoginIsDisplayed = loginPage.buttonLogin.isDisplayed();
        Assert.assertTrue(buttonLoginIsDisplayed);
    }

    @Test(priority = 2)
    void invalid_creds_login_validation_test() throws InterruptedException {
        Credentials creds = Input.credentials.invalid;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(creds);

        boolean errorMessageIsDisplayed = loginPage.errorMessage.isDisplayed();
        Assert.assertTrue(errorMessageIsDisplayed);
    }

    @Test(priority = 3)
    void empty_creds_login_validation_test() throws InterruptedException {
        Credentials creds = Input.credentials.empty;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(creds);

        boolean loginButtonIsDisplayed = loginPage.buttonLogin.isDisplayed();
        Assert.assertTrue(loginButtonIsDisplayed);
    }
}
