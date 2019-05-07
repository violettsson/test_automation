package tests.employee_management;

import core.model.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.LoginPage;
import pages.home.HomePage;
import pages.home.employee.EditPage;
import tests.BaseTest;
import tests.Input;

public class DeletingTest extends BaseTest {

    @Test(priority = 11)
    void delete_employee_from_home_page_list_test() throws InterruptedException {
        Credentials creds = Input.credentials.valid;

        HomePage homePage = new LoginPage(driver).login(creds);
        String employeeFullName = homePage.firstEmployeePosition.getText();
        int employeeSizeBeforeAdding = homePage.fetchDuplicatesCount(employeeFullName);
        homePage.deleteEmployee();

        /* Due to long deleting and list refreshing. */
        Thread.sleep(5000);
        int employeeSizeAfterAdding = homePage.fetchDuplicatesCount(employeeFullName);

        Assert.assertTrue(employeeSizeAfterAdding < employeeSizeBeforeAdding);
    }

    @Test(priority = 12)
    void cancel_to_delete_employee_from_home_page_list_test() throws InterruptedException {
        HomePage homePage = new HomePage(driver).cancelToDeleteEmployee();

        boolean buttonDeleteIsDisabled = homePage.buttonDeleteFromHomePage.isEnabled();
        Assert.assertTrue(buttonDeleteIsDisabled);
    }

    @Test(priority = 13)
    void delete_employee_from_edit_page_list_test() {
        HomePage homePage = new HomePage(driver)
                .moveToEditPage()
                .deleteEmployeeOnEditPage();

        boolean buttonDeleteIsDisabled = homePage.buttonDeleteFromHomePage.isEnabled();
        Assert.assertTrue(buttonDeleteIsDisabled);
    }

    @Test(priority = 14)
    void cancel_to_delete_employee_from_edit_page_list_test() {
        EditPage editPage = new HomePage(driver)
                .moveToEditPage()
                .cancelDeleteEmployeeOnEditPage();

        boolean buttonBackisDisplayed = editPage.buttonBack.isEnabled();
        Assert.assertTrue(buttonBackisDisplayed);
    }
}
