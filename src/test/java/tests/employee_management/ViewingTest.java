package tests.employee_management;

import core.model.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.LoginPage;
import pages.home.HomePage;
import pages.home.employee.EditPage;
import tests.BaseTest;
import tests.Input;

public class ViewingTest extends BaseTest {

    @Test(priority = 2)
    void view_employee_details_by_double_clicking_test() throws InterruptedException {

        Credentials creds = Input.credentials.valid;

        EditPage editPage = new LoginPage(driver)
                .login(creds)
                .moveToEditPageByDoubleClick();

        boolean buttonUpdateIsDisplayed = editPage.buttonUpdate.isDisplayed();
        Assert.assertTrue(buttonUpdateIsDisplayed);

        HomePage homePage = editPage.moveBackToHomePage();

        boolean greetingsIsDisplayed = homePage.greetings.isDisplayed();
        Assert.assertTrue(greetingsIsDisplayed);
    }
}
